package com.example.assignment1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.databinding.ItemViewBinding
import com.example.assignment1.databinding.ItemViewForPage2Binding
import com.example.assignment1.dataforpage2.Id

class AdapterForPage2(var list: List<Id>) : RecyclerView.Adapter<AdapterForPage2.ViewHolder>() {
    class ViewHolder(var itemViewForPage2Binding: ItemViewForPage2Binding) :
        RecyclerView.ViewHolder(itemViewForPage2Binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemViewForPage2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data= list[position]
        holder.itemViewForPage2Binding.text2.text=data.title
        holder.itemViewForPage2Binding.discountedPrice.text=data.discounted_price
        holder.itemViewForPage2Binding.totalPrice.text=data.total_price
        holder.itemViewForPage2Binding.duration.text=data.duration
        holder.itemViewForPage2Binding.videoDescription.text=data.video_description
        holder.itemViewForPage2Binding.description.text=data.description
        holder.itemViewForPage2Binding.currencyCode.text=data.currency_code
    }
}