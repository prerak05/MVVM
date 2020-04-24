package com.example.mvvm.module.indiacoronastatus.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndiaCoronaDetail(
    @SerializedName("cases_time_series")
    @Expose
    var casesTimeSeries: ArrayList<CasesTimeSeries>,
    @SerializedName("statewise")
    @Expose
    var statewise: ArrayList<Statewise>,
    @SerializedName("tested")
    @Expose
    var tested: ArrayList<Tested>
): Parcelable