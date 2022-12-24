package com.eunjeong.kotlinbasic01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.kotlinbasic01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        
    }
}