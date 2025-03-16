package com.example.weatherapp.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.api.Constants
import com.example.weatherapp.api.NetworkResponse
import com.example.weatherapp.api.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherResponse>>()
    val weatherResult: LiveData<NetworkResponse<WeatherResponse>> = _weatherResult

    fun getWeatherData(city: String) {
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeatherData(Constants.API_KEY, "Galle")
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Failed to fetch data")
                }

            } catch (e: Exception) {
                _weatherResult.value = NetworkResponse.Error("Failed to fetch data")
                Log.e("WeatherViewModel", "getWeatherData: ${e.message}")
            }
        }
    }
}