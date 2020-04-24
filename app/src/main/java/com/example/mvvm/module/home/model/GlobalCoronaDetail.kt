package com.example.coroutine.service.model.globalcoronastatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GlobalCoronaDetail(
    @SerializedName("results")
    val results: List<Result>?,

    @SerializedName("stat")
    var stat: String?

)