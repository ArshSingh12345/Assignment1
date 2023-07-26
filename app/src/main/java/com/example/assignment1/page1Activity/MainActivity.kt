package com.example.assignment1.page1Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.R
import com.example.assignment1.adapter.Adapter1
import com.example.assignment1.apiutils.RetrofitImplementationForPage1
import com.example.assignment1.databinding.ActivityMainBinding
import com.example.assignment1.page2activity.ActivityForPage2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private lateinit var adapter1: Adapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getSymptoms()
        val button = mBinding.button

        // Call the method to enable/disable the button initially
        updateButtonState()
        mBinding.button.setOnClickListener {
            showSelectedData()
        }
        mBinding.linearLayout.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityForPage2::class.java)
            startActivity(intent)
        }
    }
    fun getSymptoms() {
        lifecycleScope.launch(Dispatchers.IO) {
            val res = RetrofitImplementationForPage1.getInstance().getSymptoms()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    val model1 = res.body() // Assuming API returns Model1
                    val symptomsList = model1?.list
                    mBinding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter1 = symptomsList?.let { Adapter1(it,mBinding.button) }!!
                    mBinding.recyclerView.adapter = adapter1
                } else {
                    Log.e("MainActivity", "API Error: ${res.message()}")
                }
            }
        }
    }

    private fun showSelectedData() {
        val selectedItems = adapter1.getSelectedItems()
        val intent = Intent(this, ResultActivity::class.java)
        intent.putParcelableArrayListExtra("selected_items", ArrayList(selectedItems))
        startActivity(intent)
    }
    private fun updateButtonState() {
        // Check if adapter1 is initialized before performing the update
        if (::adapter1.isInitialized) {
            // Enable the button if any checkbox is selected, otherwise, disable it
            mBinding.button.isEnabled = adapter1.getSelectedItems().isNotEmpty()
        }
    }
}
