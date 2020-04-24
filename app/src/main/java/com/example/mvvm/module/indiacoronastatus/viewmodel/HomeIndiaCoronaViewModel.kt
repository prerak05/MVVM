package com.example.mvvm.module.indiacoronastatus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.module.indiacoronastatus.model.IndiaCoronaDetail
import com.example.mvvm.service.repository.ProjectRepository

class HomeIndiaCoronaViewModel : ViewModel() {

    fun getDetail(): LiveData<IndiaCoronaDetail> {
        return ProjectRepository("https://api.covid19india.org").getIndianCoronaDetail()
    }
}