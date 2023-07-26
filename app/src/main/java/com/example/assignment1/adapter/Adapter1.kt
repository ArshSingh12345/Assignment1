package com.example.assignment1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.databinding.ItemViewBinding
import com.example.assignment1.dataforpage1.Id

class Adapter1(var list: List<Id>,private val button:Button): RecyclerView.Adapter<Adapter1.ViewHolder>() {
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

        holder.itemViewBinding.checkbox.setOnClickListener {
            data.isSelected = !data.isSelected // Toggle the isSelected property
            updateButtonState() // Update the button state based on checkbox selection
            notifyDataSetChanged() // Notify the adapter that the data has changed
        }

        // Update button state initially based on the checkbox selection
        updateButtonState()
    }
    fun getSelectedItems(): List<Id> {
        return list.filter { it.isSelected }
    }


    private fun updateButtonState() {
        // Enable the button if any checkbox is selected, otherwise, disable it
        button.isEnabled = list.any { it.isSelected }
    }
}