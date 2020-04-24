package com.example.mvvm.module.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutine.service.model.globalcoronastatus.GlobalCoronaDetail
import com.example.mvvm.service.repository.ProjectRepository

class WorldCoronaStatusViewModel : ViewModel() {
    val globalCoronaCase = MutableLiveData<GlobalCoronaDetail?>()
    val globalCoronaCaseError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun refreshData() {
        fetchGlobalCoronaCase()
    }

     fun fetchGlobalCoronaCase(): LiveData<GlobalCoronaDetail?>? {
//      loading.value = true
      return ProjectRepository("https://api.thevirustracker.com").getWorldCoronaStatus()
    }
}