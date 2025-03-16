package com.example.weatherapp.models

import android.util.Log
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    fun getWeatherData(city: String){
        Log.d("WeatherViewModel", "City: $city")
    }
}