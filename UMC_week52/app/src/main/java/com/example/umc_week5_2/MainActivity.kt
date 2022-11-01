package com.example.umc_week5_2

import android.content.Intent
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

        //데이터 넣기
        viewBinding.btnAdd.setOnClickListener {
            var intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
        }
        val extras = intent.extras
        //val data = extras!!["title"] as String
        val data = intent.getStringExtra("title").toString()

        //val data2 = extras!!["content"] as String
        //viewBinding.rvData.text = data


        val dataList: ArrayList<Data> = arrayListOf()
        dataList.apply{
            add(Data("$data", "content1"))
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