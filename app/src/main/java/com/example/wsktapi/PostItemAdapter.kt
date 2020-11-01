package com.example.wsktapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class PostItemAdapter(val postList: List<Post>, val context: Context) :
    RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.txtPostjobNo.text = postList[position].jobNo
        holder.itemView.txtPosttruckLicense.text = postList[position].truckLicense
        holder.itemView.txtPostprovince.text = postList[position].province
        holder.itemView.txtPosttruckType.text = postList[position].truckType

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}