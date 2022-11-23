package com.example.umc_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week8.databinding.ActivityLockerBinding
import com.example.umc_week8.databinding.ActivityMainBinding

class LockerActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLockerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLockerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}