package com.example.mvvm.module.indiacoronastatus.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CasesTimeSeries(
    @SerializedName("dailyconfirmed")
    @Expose
    var dailyconfirmed: String? = "0",
    @SerializedName("dailydeceased")
    @Expose
    var dailydeceased: String? = "0",
    @SerializedName("dailyrecovered")
    @Expose
    var dailyrecovered: String? = "0",
    @SerializedName("date")
    @Expose
    var date: String? = "0",
    @SerializedName("totalconfirmed")
    @Expose
    var totalconfirmed: String? = "0",
    @SerializedName("totaldeceased")
    @Expose
    var totaldeceased: String? = "0",
    @SerializedName("totalrecovered")
    @Expose
    var totalrecovered: String? = "0"

): Parcelable