package com.example.assignment1.page2activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.R
import com.example.assignment1.adapter.Adapter1
import com.example.assignment1.adapter.AdapterForPage2
import com.example.assignment1.apiutils.RetrofitImplementationForPage1
import com.example.assignment1.apiutils.RetrofitImplementationForPage2
import com.example.assignment1.databinding.ActivityForPage2Binding
import com.example.assignment1.page1Activity.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityForPage2 : AppCompatActivity() {
    lateinit var mBinding: ActivityForPage2Binding
    lateinit var adapter2: AdapterForPage2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mBinding= DataBindingUtil.setContentView(this,R.layout.activity_for_page2)
getData()
        mBinding.image.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val res = RetrofitImplementationForPage2.getInstance().getData()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    val model1 = res.body() // Assuming API returns Model1
                    val symptomsList = model1?.list
                    mBinding.RecyclerView2.layoutManager = LinearLayoutManager(this@ActivityForPage2,LinearLayoutManager.HORIZONTAL,false)
                    adapter2 = symptomsList?.let { AdapterForPage2(it) }!!
                    mBinding.RecyclerView2.adapter = adapter2
                } else {
                    Log.e("MainActivity", "API Error: ${res.message()}")
                }
            }
        }
    }
}