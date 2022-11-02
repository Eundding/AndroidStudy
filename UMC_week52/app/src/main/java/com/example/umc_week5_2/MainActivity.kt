package com.example.umc_week5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week5_2.databinding.ActivityMainBinding
import java.util.logging.Handler

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
        val data2 = intent.getStringExtra("content").toString()

        val dataList: ArrayList<Data> = arrayListOf()
        dataList.apply{
            add(Data("title1", "content1"))
            add(Data("title2", "content2"))
            add(Data("title3", "content3"))
            add(Data("title4", "content4"))
            add(Data("title5", "content5"))
            add(Data("title6", "content6"))
            add(Data("title7", "content7"))
            add(Data("title8", "content8"))
        }



        val dataRVAdapter = DataRVAdapter(dataList)

        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this) //까먹으면 안됨

        android.os.Handler(mainLooper).postDelayed({
            dataList.apply{
                add(Data("$data", "$data2"))
            }
            dataRVAdapter.notifyItemRangeInserted(8, 1)
        }, 1000)


    }
}