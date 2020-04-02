package com.example.wammy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wammy.R
import com.example.wammy.model.Todou


class DummyAdapter(
    private var dataList: Todou,
    private val context: Context
) :
    RecyclerView.Adapter<DummyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.listnews,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.titleTextView.text = dataModel.title
        holder.adbody.text = dataModel.body
        holder.adid.text = dataModel.id.toString()


    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

        var titleTextView: TextView = itemLayoutView.findViewById(R.id.adnews)
        var adbody: TextView = itemLayoutView.findViewById(R.id.adbody)
        var adid: TextView = itemLayoutView.findViewById(R.id.adid)
        // var logout: ImageView = itemLayoutView.findViewById(R.id.listidentifierlogout)
        //   lateinit var description: TextView
        //  lateinit var image:ImageView


    }


}