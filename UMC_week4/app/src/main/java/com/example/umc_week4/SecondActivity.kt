package com.example.umc_week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week4.databinding.ActivityMainBinding
import com.example.umc_week4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //정보 받기
        val extras = intent.extras
        val data = extras!!["input"] as String
        viewBinding.sendTV.text = data
    }


}