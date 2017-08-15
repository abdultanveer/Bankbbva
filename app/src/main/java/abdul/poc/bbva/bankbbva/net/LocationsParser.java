package abdul.poc.bbva.bankbbva.net;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import abdul.poc.bbva.bankbbva.model.BankLocation;

import static android.content.ContentValues.TAG;

/**
 * Created by Ansari on 8/11/2017.
 */

public class LocationsParser {
    public  static String RESULTS = "results";
    public  static String GEOMETRY = "geometry";
    public  static String LOCATION = "location";
    public static String FORMATTED_ADDRESS = "formatted_address";
    public  static String LATITUDE = "lat";
    public static String LONGITUDE = "lng";

 //public static ArrayList<BankLocation> bankLocations = new ArrayList<>();
    public static BankLocation[] bankLocations = new BankLocation[15];

    public static void parseJson(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject resultObject = jsonArray.getJSONObject(i);
                //Log.i(TAG,resultObject.toString());
                String formattedAddres = resultObject.getString(FORMATTED_ADDRESS);
                // Log.i(TAG,formattedAddres);

                JSONObject geometryObject = resultObject.getJSONObject(GEOMETRY);
                // Log.i(TAG,geometryObject.toString());

                JSONObject locationObject = geometryObject.getJSONObject(LOCATION);
                /// Log.i(TAG,locationObject.toString());
                double latitude = Double.parseDouble(locationObject.getString(LATITUDE));
                double longitude = Double.parseDouble(locationObject.getString(LONGITUDE));

                BankLocation bbvaLocation = new BankLocation(latitude,longitude,formattedAddres);
                Log.i(TAG,bbvaLocation.toString());

                addToArray(bbvaLocation);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
static int i = 0;
    public static void addToArray(BankLocation bankLocation) {
        bankLocations[i] = bankLocation;
        i++;
       // bankLocations.add(bankLocation) ;

    }
     public static BankLocation[] getBankLocations(){
         return  bankLocations;
                 //bankLocations.toArray(new BankLocation[bankLocations.size()]);
     }

}
