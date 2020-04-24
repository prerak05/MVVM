package com.example.mvvm.module.indiacoronastatus.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Statewise(
    @SerializedName("active")
    @Expose
    var active: String? = null,
    @SerializedName("confirmed")
    @Expose
    var confirmed: String? = null,
    @SerializedName("deaths")
    @Expose
    var deaths: String? = null,
    @SerializedName("deltaconfirmed")
    @Expose
    var deltaconfirmed: String? = null,
    @SerializedName("deltadeaths")
    @Expose
    var deltadeaths: String? = null,
    @SerializedName("deltarecovered")
    @Expose
    var deltarecovered: String? = null,
    @SerializedName("lastupdatedtime")
    @Expose
    var lastupdatedtime: String? = null,
    @SerializedName("recovered")
    @Expose
    var recovered: String? = null,
    @SerializedName("state")
    @Expose
    var state: String? = null,
    @SerializedName("statecode")
    @Expose
    var statecode: String? = null,
    @SerializedName("statenotes")
    @Expose
    var statenotes: String? = null

) : Parcelable