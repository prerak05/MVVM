package com.example.mvvm.service.repository

import com.example.coroutine.service.model.globalcoronastatus.GlobalCoronaDetail
import com.example.mvvm.module.indiacoronastatus.model.IndiaCoronaDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("free-api")
    fun getGlobalCoronaCase(@Query("global") global: String?): Call<GlobalCoronaDetail>

    @GET("data.json")
    fun getIndianCoronaDetail(): Call<IndiaCoronaDetail>
}