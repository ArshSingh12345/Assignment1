package com.example.assignment1.interfacepackage

import com.example.assignment1.dataforpage1.Model1
import com.example.assignment1.dataforpage2.Model2
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceForPage2 {
    @GET("api/plan/all")
    suspend fun getData(): Response<Model2>
}