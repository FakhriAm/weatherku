package indah.com.wheaterapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecast implements Parcelable {
    public static final Parcelable.Creator<Forecast> CREATOR = new Parcelable.Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel source) {
            return new Forecast(source);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
    @SerializedName("forecastday")
    private List<Forecastday> forecastDay = new ArrayList<Forecastday>();

    public Forecast() {
    }

    protected Forecast(Parcel in) {
        this.forecastDay = in.createTypedArrayList(Forecastday.CREATOR);
    }

    public List<Forecastday> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(List<Forecastday> forecastDay) {
        this.forecastDay = forecastDay;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.forecastDay);
    }
}
