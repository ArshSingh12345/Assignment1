package com.example.assignment1.interfacepackage

import com.example.assignment1.dataforpage1.Model1
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceForPage1 {
 @GET("api/user/symptoms")
 suspend fun getSymptoms():Response<Model1>
}