package abdul.poc.bbva.bankbbva.net;



import android.os.AsyncTask;
import android.util.Log;

import abdul.poc.bbva.bankbbva.model.BankLocation;


/**
     * Async task class to get json by making HTTP call
     */
   public   class GetLocationTask  extends AsyncTask<String, Void, GetLocationTask.Result> {
    private static final String TAG = GetLocationTask.class.getName();
    private DownloadCallback<BankLocation> mCallback;

    public GetLocationTask(DownloadCallback<BankLocation> callback) {
        setCallback(callback);
    }

    void setCallback(DownloadCallback<BankLocation> callback) {
        mCallback = callback;
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }
        @Override
        protected GetLocationTask.Result doInBackground(String... arg0) {
            HttpHandler handler = new HttpHandler();

            // Making a request to url and getting response
            String jsonString = handler.makeServiceCall(arg0[0]);
            Log.e(TAG, "Response from url: " + jsonString);
            LocationsParser.parseJson(jsonString);
            return  new Result(LocationsParser.getBankLocations())  ;

      }

  // public abstract void onResponseReceived(ArrayList<BankLocation> locations);
    @Override
        protected void onPostExecute(Result result) {
        if (result != null && mCallback != null) {
            if (result.mException != null) {
                mCallback.updateFromDownload(result.mException.getMessage());
            } else if (result.bankLocations != null) {
                mCallback.updateFromDownload(result.bankLocations);
            }
            mCallback.finishDownloading();
        }

            }

    static class Result {
        BankLocation[] bankLocations;
        public Exception mException;
        public Result(BankLocation[] locations){bankLocations = locations;}
        public Result(Exception exception) {
            mException = exception;
        }
    }
        }

