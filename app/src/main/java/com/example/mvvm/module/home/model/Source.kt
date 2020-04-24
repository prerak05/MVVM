package com.example.coroutine.service.model.globalcoronastatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source {
    @SerializedName("url")
    @Expose
    var url: String? = null

}