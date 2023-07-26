package com.example.assignment1.apiutils

import com.example.assignment1.interfacepackage.ApiInterfaceForPage1
import com.example.assignment1.interfacepackage.ApiInterfaceForPage2
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImplementationForPage2 {
    companion object {
        fun getInstance(): ApiInterfaceForPage2 {
            return Retrofit.Builder().baseUrl("http://dev.mimblu.com/mimblu-yii2-1552/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(
                    ApiInterfaceForPage2::class.java
                )
        }
    }
}