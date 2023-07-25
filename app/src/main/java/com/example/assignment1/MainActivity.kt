package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.adapter.Adapter1
import com.example.assignment1.apiutils1forpage1.RetrofitImplementationForPage1
import com.example.assignment1.databinding.ActivityMainBinding
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
        mBinding.button.setOnClickListener {
            showSelectedData()
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
                    adapter1 = symptomsList?.let { Adapter1(it) }!!
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
}
