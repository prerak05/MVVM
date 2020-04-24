package com.example.mvvm.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutine.service.model.globalcoronastatus.GlobalCoronaDetail
import com.example.mvvm.module.indiacoronastatus.model.IndiaCoronaDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProjectRepository {

    private var apiService: ApiService? = null;
//    private var BASE_URL= "https://api.thevirustracker.com"

    constructor()

    constructor(BASE_URL: String?) {
//        this.BASE_URL = BASE_URL
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    companion object {
        private var projectRepository: ProjectRepository? = null
        @get:Synchronized
        val instance: ProjectRepository?
            get() {
                if (projectRepository == null) {
                    if (projectRepository == null) {
                        projectRepository =
                            ProjectRepository()
                    }
                }
                return projectRepository
            }
    }

//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        apiService = retrofit.create(ApiService::class.java)
//    }

    fun getWorldCoronaStatus(): LiveData<GlobalCoronaDetail?> {
        val data: MutableLiveData<GlobalCoronaDetail?> = MutableLiveData<GlobalCoronaDetail?>()
        apiService?.getGlobalCoronaCase("stats")
            ?.enqueue(object : Callback<GlobalCoronaDetail?> {
                override fun onResponse(
                    call: Call<GlobalCoronaDetail?>?,
                    response: Response<GlobalCoronaDetail?>
                ) {
                    data.setValue(response.body())
                }

                override fun onFailure(
                    call: Call<GlobalCoronaDetail?>?,
                    t: Throwable?
                ) {
                    data.setValue(null)
                }
            })
        return data
    }


    fun getIndianCoronaDetail(): LiveData<IndiaCoronaDetail> {
        val data = MutableLiveData<IndiaCoronaDetail>()
        apiService?.getIndianCoronaDetail()?.enqueue(
            object : Callback<IndiaCoronaDetail> {
                override fun onFailure(call: Call<IndiaCoronaDetail>, t: Throwable) {
                    data.value = null
                }

                override fun onResponse(
                    call: Call<IndiaCoronaDetail>,
                    response: Response<IndiaCoronaDetail>
                ) {
                    data.value = response.body()
                }

            }
        )
        return data
    }

}