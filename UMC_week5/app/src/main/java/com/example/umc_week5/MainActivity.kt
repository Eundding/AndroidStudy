package com.example.umc_week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Log.d("Lifecycle", "onCreate")

        val dataList: ArrayList<Data> = arrayListOf()

        dataList.apply{
            add(Data("hello", "1"))
            add(Data("hello", "2"))
            add(Data("hello", "3"))
            add(Data("hello", "4"))
            add(Data("hello", "5"))
            add(Data("hello", "6"))
            add(Data("hello", "7"))
            add(Data("hello", "8"))
            add(Data("hello", "9"))
            add(Data("hello", "10"))
            add(Data("hello", "11"))
            add(Data("hello", "12"))
            add(Data("hello", "13"))
            add(Data("hello", "14"))
            add(Data("hello", "15"))
            add(Data("hello", "16"))
        }

        val dataRVAdapter = DataRVAdapter(dataList)

        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this) //까먹으면 안됨!!!!!!!!!!!!!!!!!!!

        // 데이터 추가가
       Handler(mainLooper).postDelayed({
            dataList.apply {
                add(Data("hello", "17"))
                add(Data("hello", "18"))
                add(Data("hello", "19"))
                add(Data("hello", "20"))
            }
            dataRVAdapter.notifyItemRangeInserted(16, 4)
        }, 1000)
    }


}