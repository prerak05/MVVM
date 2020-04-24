package com.example.mvvm.module.indiacoronastatus.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.module.indiacoronastatus.model.CasesTimeSeries
import com.example.mvvm.module.indiacoronastatus.view.adapter.DateWiseCaseAdapter
import kotlinx.android.synthetic.main.activity_date_wise_case.*

class DateWiseCaseActivity : AppCompatActivity() {
    private var dateViseList: ArrayList<CasesTimeSeries> = ArrayList()
    private var dateWiseAdapter = DateWiseCaseAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_wise_case)
        supportActionBar?.title = "Date Wise Case"
        val data = intent.getParcelableArrayListExtra<CasesTimeSeries>("dateWise")
        if (data !== null && data.size > 0) {
            dateViseList.addAll(data)
            dateWiseAdapter.updateData(data)
            rvDateWiseCase.apply {
                layoutManager = LinearLayoutManager(this@DateWiseCaseActivity)
                adapter = dateWiseAdapter
            }
        }
    }
}
