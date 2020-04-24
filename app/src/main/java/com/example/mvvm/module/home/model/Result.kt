package com.example.coroutine.service.model.globalcoronastatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("total_cases")
    @Expose
    var totalCases: Long?,
    @SerializedName("total_recovered")
    @Expose
    var totalRecovered: Long?,
    @SerializedName("total_unresolved")
    @Expose
    var totalUnresolved: Long?,
    @SerializedName("total_deaths")
    @Expose
    var totalDeaths: Long?,
    @SerializedName("total_new_cases_today")
    @Expose
    var totalNewCasesToday: Long?,
    @SerializedName("total_new_deaths_today")
    @Expose
    var totalNewDeathsToday: Long?,
    @SerializedName("total_active_cases")
    @Expose
    var totalActiveCases: Long?,
    @SerializedName("total_serious_cases")
    @Expose
    var totalSeriousCases: Long?,
    @SerializedName("total_affected_countries")
    @Expose
    var totalAffectedCountries: Long?,
    @SerializedName("source")
    @Expose
    var source: Source?

)