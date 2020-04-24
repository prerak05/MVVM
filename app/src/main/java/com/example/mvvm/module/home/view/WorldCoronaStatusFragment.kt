package com.example.mvvm.module.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.module.home.viewmodel.WorldCoronaStatusViewModel
import kotlinx.android.synthetic.main.fragment_world_coron_status.*

class WorldCoronaStatusFragment : Fragment() {

    private lateinit var homeViewModel: WorldCoronaStatusViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(WorldCoronaStatusViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_world_coron_status, container, false)
        observerViewModel(homeViewModel)
        return root
    }

    private fun observerViewModel(viewModel: WorldCoronaStatusViewModel) {
        this.activity?.let {
            viewModel.fetchGlobalCoronaCase()?.observe(it, Observer { globalCases ->
                if (globalCases?.stat.equals("ok")) {
                    progressBar.visibility = View.GONE
                    tvTotalCase.text = globalCases?.results?.get(0)?.totalCases.toString()
                    tvTotalRecovered.text = globalCases?.results?.get(0)?.totalRecovered.toString()
                    tvTotalUnRecovered.text =
                        globalCases?.results?.get(0)?.totalUnresolved.toString()
                    tvTotalDeaths.text = globalCases?.results?.get(0)?.totalDeaths.toString()
                    tvTotalNewCase.text =
                        globalCases?.results?.get(0)?.totalNewCasesToday.toString()
                    tvTotalNewDeaths.text =
                        globalCases?.results?.get(0)?.totalNewDeathsToday.toString()
                    tvTotalActiveCase.text =
                        globalCases?.results?.get(0)?.totalActiveCases.toString()
                    tvTotalSeriousCase.text =
                        globalCases?.results?.get(0)?.totalSeriousCases.toString()
                    tvTotalAffectedCountry.text =
                        globalCases?.results?.get(0)?.totalAffectedCountries.toString()
                }
            })
        }
    }
}
