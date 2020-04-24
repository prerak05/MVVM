package com.example.mvvm.module.indiacoronastatus.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.module.indiacoronastatus.model.Statewise
import com.example.mvvm.module.indiacoronastatus.view.adapter.StateWiseCaseAdapter
import kotlinx.android.synthetic.main.activity_state_wise.*

class StateWiseActivity : AppCompatActivity() {
    private var stateWiseList:ArrayList<Statewise> = arrayListOf()
    private val stateWiseAdapter = StateWiseCaseAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_wise)
        supportActionBar?.title = "State Wise Case"
        val data = intent.getParcelableArrayListExtra<Statewise>("stateWise")
        if (data !== null && data.size > 0) {
            stateWiseList.addAll(data)
            stateWiseAdapter.updateData(data)
            rvStateWiseCase.apply {
                layoutManager = LinearLayoutManager(this@StateWiseActivity)
                adapter = stateWiseAdapter
            }
        }
    }
}
