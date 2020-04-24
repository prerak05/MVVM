package com.example.mvvm.module.indiacoronastatus.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.module.indiacoronastatus.model.CasesTimeSeries
import com.example.mvvm.module.indiacoronastatus.model.IndiaCoronaDetail
import com.example.mvvm.module.indiacoronastatus.model.Statewise
import com.example.mvvm.module.indiacoronastatus.model.Tested
import com.example.mvvm.module.indiacoronastatus.view.activity.DateWiseCaseActivity
import com.example.mvvm.module.indiacoronastatus.view.activity.StateWiseActivity
import com.example.mvvm.module.indiacoronastatus.viewmodel.HomeIndiaCoronaViewModel

class HomeIndiaCoronaFragment : Fragment() {

    private lateinit var viewModel: HomeIndiaCoronaViewModel
    private lateinit var dataWise: ArrayList<CasesTimeSeries>
    private lateinit var stateWise: List<Statewise>
    private lateinit var tested: List<Tested>
    private lateinit var data: IndiaCoronaDetail

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(HomeIndiaCoronaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home_india_corona, container, false)
        observeViewModel()
        initView(root, this.activity)
        return root
    }

    private fun initView(
        root: View?,
        activity: FragmentActivity?
    ) {
        val btnDateWise = root?.findViewById<Button>(R.id.btnCountryWise)
        val btnStateWise = root?.findViewById<Button>(R.id.btnStateWise)
//        val btnTested = root?.findViewById<Button>(R.id.btnTested)
        btnDateWise?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (dataWise.size > 0) {
//                Toast.makeText(this, "Navigate", Toast.LENGTH_SHORT)
                    val intent = Intent(activity, DateWiseCaseActivity::class.java)
                    intent.putParcelableArrayListExtra("dateWise", data.casesTimeSeries)
                    startActivity(intent)
                } else {
                    println("Currently no data available.")
                }
            }
        })

        btnStateWise?.setOnClickListener {
            val intent = Intent(activity, StateWiseActivity::class.java)
            intent.putParcelableArrayListExtra("stateWise", data.statewise)
            startActivity(intent)
        }
    }

    private fun observeViewModel() {
        this.activity?.let {
            viewModel.getDetail().observe(it, Observer { getDetail ->
                if (getDetail != null) {
                    Log.d("----> ", getDetail.casesTimeSeries[35].totalconfirmed)
                    data = getDetail
                    if (data.casesTimeSeries.size > 0) {
                        dataWise = getDetail.casesTimeSeries
                    }
                    if (data.statewise.size > 0) {
                        stateWise = getDetail.statewise
                    }
                    if (data.tested.size > 0) {
                        tested = getDetail.tested
                    }
                }

            })
        }

    }
}
