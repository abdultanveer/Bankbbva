package abdul.poc.bbva.bankbbva;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import abdul.poc.bbva.bankbbva.fragments.BankListFragment;
import abdul.poc.bbva.bankbbva.model.BankLocation;
import abdul.poc.bbva.bankbbva.net.DownloadCallback;
import abdul.poc.bbva.bankbbva.net.GetLocationTask;
import abdul.poc.bbva.bankbbva.util.Constants;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener,DownloadCallback<BankLocation>{

    private GoogleMap mMap;
    BankLocation[] bankLocations;
    DownloadCallback<BankLocation> mCallback;
    FloatingActionButton fab;
    OnLocationsListener onLocationsListener;



    public interface OnLocationsListener {
        public void onLocations(BankLocation[] locations,Context context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        mCallback = (DownloadCallback<BankLocation>)this;
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
        GetLocationTask getLocationTask = new GetLocationTask(mCallback);
        getLocationTask.execute(Constants.WEB_URL);
         fab = (FloatingActionButton) findViewById(R.id.fab);

    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setOnInfoWindowClickListener(this);
    }

    private void addMarkers(GoogleMap mMap, BankLocation[] locations) {
      //  BankLocation[] bankLocations = locations;
                //Constants.BANK_LOCATIONS_TEST_DATA;
        LatLng latlon = new LatLng(bankLocations[4].getLatitude(),bankLocations[0].getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlon));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                latlon).zoom(10).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        for(int i=0;i<11;i++){
            BankLocation location = bankLocations[i];
            MarkerOptions marker = new MarkerOptions()
                    .position(new LatLng(location.getLatitude(),location.getLongitude()))
                    .title(location.getFormattedAddress());
            mMap.addMarker(marker);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Toast.makeText(this, marker.getSnippet(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFromDownload(final BankLocation[] locations) {
        bankLocations = locations;
        addMarkers(mMap,locations);
       fab.setEnabled(true);
       // final BankListFragment bankListFragment = new BankListFragment();

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MapsActivity.this,"fab clicked",Toast.LENGTH_SHORT).show();

                //getFragmentManager().beginTransaction().add(bankListFragment)
              //  BankListFragment bankListFragment = (BankListFragment) getFragmentManager().findFragmentById(R.id.bank_list_fragment);
                BankListFragment bankListFragment = new BankListFragment();
             //  bankListFragment.setArguments(new Bundle().putParcelableArray("BANK_LOCATIONS",  bankLocations));
               getFragmentManager().beginTransaction().add(R.id.linear_layout_fragments,bankListFragment,"BANK_FRAGMENT").commit();
                       // getFragmentManager().beginTransaction().replace(R.id.mapFragment,bankListFragment).commit();
               // getFragmentManager().beginTransaction().add(bankListFragment,"").commit();
               // bankListFragment.setData(bankLocations);
               /* onLocationsListener = (OnLocationsListener)bankListFragment;

                onLocationsListener.onLocations(locations,MapsActivity.this);*/


            }
        });

    }

    @Override
    public void updateFromDownload(String result) {

    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {

    }

    @Override
    public void finishDownloading() {

    }
}
