package com.example.weatherapp.api

import com.example.weatherapp.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getWeatherData(
        @Query("key") apiKey: String,
        @Query("q") city: String,
    ): Response<WeatherResponse>
}