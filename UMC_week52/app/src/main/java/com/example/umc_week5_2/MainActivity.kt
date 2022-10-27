package com.example.umc_week5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<Data> = arrayListOf()

        dataList.apply{
            add(Data("title1", "content1"))
            add(Data("title2", "content1"))
            add(Data("title3", "content1"))
            add(Data("title4", "content1"))
            add(Data("title5", "content1"))
            add(Data("title6", "content1"))

        }

        val dataRVAdapter = DataRVAdapter(dataList)

        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this) //까먹으면 안됨
    }
}