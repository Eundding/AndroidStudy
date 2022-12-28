package com.eunjeong.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.intent.databinding.ActivityMainBinding
import com.eunjeong.intent.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityOtherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.moveToPrevBtn.setOnClickListener {
//            val myIntent = Intent(this, MainActivity::class.java)
//            startActivity(myIntent)
            finish() // 지금 화면 꺼주세요
            // 넘어갈때는 intent 되돌아갈때는 finish 활용
        }
    }
}