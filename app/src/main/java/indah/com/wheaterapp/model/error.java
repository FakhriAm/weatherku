package indah.com.wheaterapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class error implements Parcelable {

    public static final Creator<error> CREATOR = new Creator<error>() {
        @Override
        public error createFromParcel(Parcel source) {
            return new error(source);
        }

        @Override
        public error[] newArray(int size) {
            return new error[size];
        }
    };
    @SerializedName("message")
    String message;

    public error() {
    }

    protected error(Parcel in) {
        this.message = in.readString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
    }
}
