package com.example.assignment1.page1Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.assignment1.R
import com.example.assignment1.databinding.ActivityResultBinding
import com.example.assignment1.dataforpage1.Id

class ResultActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        val selectedItems = intent.getParcelableArrayListExtra<Id>("selected_items")
        mBinding.selectedItemsTextView.text = selectedItemsText(selectedItems)
    }

    private fun selectedItemsText(selectedItems: ArrayList<Id>?): String {
        return if (selectedItems.isNullOrEmpty()) {
            "No items selected."
        } else {
            val stringBuilder = StringBuilder()
            for (item in selectedItems) {
                stringBuilder.append(item.title).append("\n")
            }
            stringBuilder.toString()
        }
    }
}