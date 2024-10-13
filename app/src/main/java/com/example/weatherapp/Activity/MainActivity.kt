package com.example.weatherapp.Activity

import WeatherViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.weatherapp.Components.LoadingScreen
import com.example.weatherapp.Components.WeatherScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    // ViewModel örneğini oluştur
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Örnek konum (Enlem: 37.7749, Boylam: -122.4194 - San Francisco)
        weatherViewModel.loadCurrentWeather(37.7749, -122.4194, "metric")

        setContent {
            WeatherAppTheme {
                // UI bileşenleri
                MainScreen(weatherViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(weatherViewModel: WeatherViewModel) {
    val weatherState by weatherViewModel.weatherData.observeAsState()

    if (weatherState != null) {
        WeatherScreen(weather = weatherState!!)
    } else {
        LoadingScreen()
    }
}


