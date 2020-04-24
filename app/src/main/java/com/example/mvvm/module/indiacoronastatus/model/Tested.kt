package com.example.mvvm.module.indiacoronastatus.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tested(
    @SerializedName("positivecasesfromsamplesreported")
    @Expose
    var positivecasesfromsamplesreported: String? = null,
    @SerializedName("samplereportedtoday")
    @Expose
    var samplereportedtoday: String? = null,
    @SerializedName("source")
    @Expose
    var source: String? = null,
    @SerializedName("testsconductedbyprivatelabs")
    @Expose
    var testsconductedbyprivatelabs: String? = null,
    @SerializedName("totalindividualstested")
    @Expose
    var totalindividualstested: String? = null,
    @SerializedName("totalpositivecases")
    @Expose
    var totalpositivecases: String? = null,
    @SerializedName("totalsamplestested")
    @Expose
    var totalsamplestested: String? = null,
    @SerializedName("updatetimestamp")
    @Expose
    var updatetimestamp: String? = null

) : Parcelable