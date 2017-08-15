package abdul.poc.bbva.bankbbva.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ansari on 8/11/2017.
 */

public class BankLocation implements Parcelable {
   private Double latitude;
    private Double longitude;
    private String formattedAddress;

    protected BankLocation(Parcel in) {
        formattedAddress = in.readString();
    }

    public static final Creator<BankLocation> CREATOR = new Creator<BankLocation>() {
        @Override
        public BankLocation createFromParcel(Parcel in) {
            return new BankLocation(in);
        }


        @Override
        public BankLocation[] newArray(int size) {
            return new BankLocation[size];
        }
    };

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public BankLocation(String latitude, String longitude, String formattedAddress) {
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.formattedAddress = formattedAddress;
    }

    public BankLocation(Double latitude, Double longitude, String formattedAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.formattedAddress = formattedAddress;
    }

    @Override
    public String toString() {
        return formattedAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(formattedAddress);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

}
