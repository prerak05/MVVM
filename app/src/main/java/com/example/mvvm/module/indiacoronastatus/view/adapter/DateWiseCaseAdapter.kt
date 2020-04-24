package com.example.mvvm.module.indiacoronastatus.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.indiacoronastatus.model.CasesTimeSeries
import kotlinx.android.synthetic.main.item_date_wise.view.*

class DateWiseCaseAdapter(var dateViseList: ArrayList<CasesTimeSeries>) :
    RecyclerView.Adapter<DateWiseCaseAdapter.ViewHolder>() {
    val data = dateViseList

    fun updateData(newData: List<CasesTimeSeries>) {
        dateViseList.clear()
        dateViseList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_date_wise, parent, false)
    )

    override fun getItemCount() = dateViseList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dateViseList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate = view.tvDate
        val tvDailyConfirmed = view.tvDailyConfirmed
        val tvDailyDeceased = view.tvDailyDeceased
        val tvDailyRecovered = view.tvDailyRecovered
        val tvTotalConfirmed = view.tvTotalConfirmed
        val tvTotalDeceased = view.tvTotalDeceased
        val tvTotalRecovered = view.tvTotalRecovered

        fun bind(dateWise: CasesTimeSeries) {
            tvDate.text = dateWise.date
            tvDailyConfirmed.text = dateWise.dailyconfirmed
            tvDailyDeceased.text = dateWise.dailydeceased
            tvDailyRecovered.text = dateWise.dailyrecovered
            tvTotalConfirmed.text = dateWise.totalconfirmed
            tvTotalDeceased.text = dateWise.totaldeceased
            tvTotalRecovered.text = dateWise.totalrecovered

        }
    }
}