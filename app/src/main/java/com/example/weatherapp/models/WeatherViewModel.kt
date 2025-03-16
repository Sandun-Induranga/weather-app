package com.example.weatherapp.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.api.Constants
import com.example.weatherapp.api.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi

    fun getWeatherData(city: String) {
        viewModelScope.launch {
            val response = weatherApi.getWeatherData(Constants.API_KEY, city)
            if (response.isSuccessful) {
//                val weatherResponse = response.body()
                Log.d("WeatherViewModel", "getWeatherData: ${response.body().toString()}")
            } else {
                Log.d("WeatherViewModel", "getWeatherData: ${response.errorBody()}")
            }
        }
    }
}