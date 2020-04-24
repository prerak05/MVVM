package com.example.mvvm.module.indiacoronastatus.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.indiacoronastatus.model.Statewise
import kotlinx.android.synthetic.main.item_state_wise.view.*

class StateWiseCaseAdapter(var list: ArrayList<Statewise>) :
    RecyclerView.Adapter<StateWiseCaseAdapter.ViewHolder>() {

    fun updateData(dataList: List<Statewise>) {
        list.clear()
        list.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_state_wise, parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate = view.tvDate
        val tvState = view.tvState
        val tvActive = view.tvActive
        val tvConfirmed = view.tvConfirmed
        val tvDeaths = view.tvDeaths
        val tvRecovered = view.tvRecovered

        fun bind(statewise: Statewise) {
            tvDate.text = statewise.lastupdatedtime
            if (statewise.state.equals("Total")) {
                tvState.text = "All States"
            } else {
                tvState.text = statewise.state
            }
            tvActive.text = statewise.active
            tvConfirmed.text = statewise.confirmed
            tvDeaths.text = statewise.deaths
            tvRecovered.text = statewise.recovered
        }
    }
}