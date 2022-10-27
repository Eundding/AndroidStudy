package com.example.umc_week5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week5_2.databinding.ActivityMainBinding
import com.example.umc_week5_2.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
    }
}