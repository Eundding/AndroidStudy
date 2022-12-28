package com.eunjeong.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.movieToOtherBtn.setOnClickListener {
            //다른 화면으로 이동
            //Intent(출발지, 도착지)
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }
    }
}