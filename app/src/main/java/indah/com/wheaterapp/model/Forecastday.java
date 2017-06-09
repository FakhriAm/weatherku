package indah.com.wheaterapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecastday implements Parcelable {
    public static final Parcelable.Creator<Forecastday> CREATOR = new Parcelable.Creator<Forecastday>() {
        @Override
        public Forecastday createFromParcel(Parcel source) {
            return new Forecastday(source);
        }

        @Override
        public Forecastday[] newArray(int size) {
            return new Forecastday[size];
        }
    };
    @SerializedName("date")
    private String date;
    @SerializedName("day")
    private Day day;
    @SerializedName("hour")
    private List<Hour> hour = new ArrayList<Hour>();

    public Forecastday() {
    }

    protected Forecastday(Parcel in) {
        this.date = in.readString();
        this.day = in.readParcelable(Day.class.getClassLoader());
        this.hour = in.createTypedArrayList(Hour.CREATOR);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Hour> getHour() {
        return hour;
    }

    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeParcelable(this.day, flags);
        dest.writeTypedList(this.hour);
    }
}
