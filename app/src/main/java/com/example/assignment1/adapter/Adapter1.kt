package com.example.assignment1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.databinding.ItemViewBinding
import com.example.assignment1.dataforpage1.Id

class Adapter1(var list: List<Id>): RecyclerView.Adapter<Adapter1.ViewHolder>() {
    class ViewHolder(var itemViewBinding:ItemViewBinding):RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data=list[position]
        holder.itemViewBinding.text1.text=data.title
        holder.itemViewBinding.checkbox.isChecked = data.isSelected

        // Set a click listener to handle checkbox selection
        holder.itemViewBinding.checkbox.setOnClickListener {
            data.isSelected = !data.isSelected // Toggle the isSelected property
            notifyDataSetChanged() // Notify the adapter that the data has changed
        }
    }
    fun getSelectedItems(): List<Id> {
        return list.filter { it.isSelected }
    }
}