package com.eunjeong.drawablexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    // 액션바에 있는 UI를 담아줄 변수
    lateinit var toastBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 액티비티에서 -> 기본 액션바를 불러내서 => custom 액션바로 수정
        //기본액션바를 불러내자
        val defaultActionBar = supportActionBar!!

        // 모드를 커스텀 지원으로 설정
        defaultActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM

        // 실제로 어떤 커스텀뷰를 사용?
        defaultActionBar.setCustomView(R.layout.my_custom)

        // 양 옆 여백 제거 필요 => 커스텀 액션바를 들고 있는 toolbar를 찾아내서 여백 제거
        // tool bar 변수에 저장
        val toolbar = defaultActionBar.customView.parent as Toolbar
        toolbar.setContentInsetsAbsolute(0, 0) // 왼오 여백

        //커스텀 액션바에 담아둔 버튼 찾아오기
        toastBtn = defaultActionBar.customView.findViewById(R.id.toastBtn)

        toastBtn.setOnClickListener {
            Toast.makeText(this, "액션바를 통한 토스트", Toast.LENGTH_SHORT).show()
        }

    }
}