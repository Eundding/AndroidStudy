package com.eunjeong.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.intent.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 이 화면에 들어올 때 첨부된 데이터를 텍스트뷰에 반영
        // val 받아줄변수 = intent.get자료형Extra("데이터이름표")
        val intentMessage = intent.getStringExtra("message")
        viewBinding.recievedMessageTv.text = intentMessage
    }
}