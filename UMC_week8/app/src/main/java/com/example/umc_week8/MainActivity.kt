package com.example.umc_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    // 데이터를 담을 배열
    val dataList = arrayListOf(
        Data("환영합니다!","메모를 시작해보세요!")
    )
    val dataRVAdapter = DataRVAdapter(dataList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.rvData.adapter = dataRVAdapter
        //recyclerview
        viewBinding.rvData.layoutManager = LinearLayoutManager(this) // 까먹으면 안됨
        viewBinding.rvData.setHasFixedSize(true)

        // 메모 작성화면으로 넘어가기
        viewBinding.btnAdd.setOnClickListener {
            var intent = Intent(this@MainActivity, MemoActivity::class.java)
            startActivity(intent)
        }

        //메모 작성 화면에서 보낸 데이터 받기
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {result ->
            if(result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("title")
                val data2 = result.data?.getStringExtra("content")
                if(data != null && data2 != null){
                    dataList.add(Data(data.toString(), data2.toString()))
                }
            }
        }

        // 메모화면으로 넘어가기
        viewBinding.btnAdd.setOnClickListener {
            var intent = Intent(this@MainActivity, MemoActivity::class.java)
            activityResultLauncher.launch(intent)
        }

        dataList.add(Data("content", "title"))
    }
}