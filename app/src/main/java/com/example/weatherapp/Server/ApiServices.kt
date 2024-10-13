package com.example.weatherapp.Server


import com.example.weatherapp.Activity.model.CurrentResponseApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//Bu kod, hava durumu API'sinden güncel verileri almak için kullanılan bir Retrofit arayüzüdür.
// Belirli bir konum (enlem ve boylam) için hava durumu bilgisi almak amacıyla HTTP GET isteği yapar
// sonuçları CurrentResponseApi veri modeliyle döndürür.

interface ApiServices {
    @GET("data/2.5/weather")
    fun  getCurrentWeather(
        @Query("lat") lat:Double, // coğrafi konum
        @Query("lon") lon:Double, //konum
        @Query("units") units:String, // metric birimi celsius döndürür
        @Query("appid") ApiKey:String, // kimlik doğrulama isteği tanıyıp izin verme
    ): Response<CurrentResponseApi>
      //apiden dönen verinin yapısını tanımlar
      //CurrentResponseApi bu model apiden dönen yanıtın nasıl işeleneceğini
      // hangi verilere erişeleceğini belirler
}