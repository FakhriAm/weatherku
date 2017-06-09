package indah.com.wheaterapp.api;

import indah.com.wheaterapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("forecast.json ")
    Call<WeatherResponse> getWeather(@Query("key") String key, @Query("q") String city, @Query("days") String days);
}
