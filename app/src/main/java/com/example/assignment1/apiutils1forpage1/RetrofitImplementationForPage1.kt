package com.example.assignment1.apiutils1forpage1

import com.example.assignment1.interfacepackage.ApiInterfaceForPage1
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImplementationForPage1 {
    //http://dev.mimblu.com/mimblu-yii2-1552/api/user/symptoms
    companion object {
        fun getInstance(): ApiInterfaceForPage1 {
            return Retrofit.Builder().baseUrl("http://dev.mimblu.com/mimblu-yii2-1552/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(
                    ApiInterfaceForPage1::class.java
                )
        }
    }
}