package com.example.weatherapp.Repository

import com.example.weatherapp.Activity.model.CurrentResponseApi
import com.example.weatherapp.Server.ApiServices
import retrofit2.Response

class WeatherRepository (private val api:ApiServices){

    suspend fun getCurrentWeather(lat: Double, long: Double, unit: String) : Response<CurrentResponseApi> {
        return api.getCurrentWeather(lat, long, unit, ApiKey = "02bae0d212ac74b12fb2099109b2709c")
    }

}