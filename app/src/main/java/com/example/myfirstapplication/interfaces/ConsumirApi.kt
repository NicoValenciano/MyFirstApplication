package com.example.myfirstapplication.interfaces

import com.example.myfirstapplication.models.Age
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ConsumirApi {
    @GET("/")
    fun getAge(@Query("name") name: String): Call<Age>
}