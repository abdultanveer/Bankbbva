package abdul.poc.bbva.bankbbva.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import abdul.poc.bbva.bankbbva.R;
import abdul.poc.bbva.bankbbva.model.BankLocation;

/**
 * Created by Ansari on 8/11/2017.
 */

public class BankListFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView bankListView;
    ArrayAdapter<BankLocation> adapter;
    Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_list_bank,container,false);
         bankListView = (ListView)view.findViewById(R.id.listViewBanks);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    BankLocation bankLocation = (BankLocation)adapterView.getAdapter().getItem(position);

    }
       public void setData(BankLocation[] bankLocations){

        }

/*    @Override
    public void onLocations(BankLocation[] locations,Context context) {
      //  adapter.addAll(locations);
        adapter = new ArrayAdapter<BankLocation>(context,
                android.R.layout.simple_list_item_1,
                bankLocations);
        //Constants.BANK_LOCATIONS_TEST_DATA);
        bankListView.setAdapter(adapter);
        bankListView.setOnItemClickListener(this);
    }*/
}
