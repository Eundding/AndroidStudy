package com.eunjeong.pizzaorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.pizzaorderapp.adapters.MainViewPagerAdapter
import com.eunjeong.pizzaorderapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var mvpa : MainViewPagerAdapter

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        // 버튼 클릭 등의 이벤트 관련 코드 모음
    }

    override fun setValues() {
        // 화면에 데이터를 표시 위한 코드 모음

        // 뷰페이저 작업
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        viewBinding.mainViewPager.adapter = mvpa


        // 뷰페이저를 탭레이아웃과 연결
        viewBinding.mainTabLayout.setupWithViewPager(viewBinding.mainViewPager)

    }


}