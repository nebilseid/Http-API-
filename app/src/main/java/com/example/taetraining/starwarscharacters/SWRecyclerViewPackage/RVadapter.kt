package com.example.taetraining.starwarscharacters.SWRecyclerViewPackage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taetraining.starwarscharacters.R

import kotlinx.android.synthetic.main.item_pass.view.*
import retrofit2.Response

class RVadapter : RecyclerView.Adapter<RVadapter.RVViewHolder>() {


    private val data = arrayListOf<Results>()
    fun setData(items: List<Results>) {

        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): RVadapter.RVViewHolder {
        val rootView = LayoutInflater.from(parent.context)

            .inflate(R.layout.item_pass, parent, false)

        return RVViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RVViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    class RVViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(results: Results) {
            view.tvTitle.text = results.title.toString()
            view.tvProducer.text = results.producer.toString()
            view.tvDirector.text = results.director.toString()
            view.tvReleaseDate.text = results.release_date.toString()

        }


    }
}

