package com.example.weatherapp.Server

import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var retrofit: Retrofit // ağ çağrılarını yönetmek için kullanılan HTTP kütüphanesi

    //Yapılandırma zaman aşımlarını ayarlamaya çalışıyor
    private val client = OkHttpClient.Builder() //HTTP isteklerini yapmak için kullanılan bir istemci
            .connectTimeout(60,TimeUnit.SECONDS) // sunucuya bağlanırken min 60 sn bekleme
        .readTimeout(60,TimeUnit.SECONDS) // istemci, sunucudan veri okurken maks 60 sn bekler
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()


    fun getClient():Retrofit{
        retrofit=Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }


}