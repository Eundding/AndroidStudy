package com.example.umc_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week6.databinding.ActivityMainBinding
import com.example.umc_week6.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)



            //어떤 화면을 기본으로 할지
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss() //commit 해야 최종적으로 반영, 그냥 커밋보다 에러 좀 무시할 수 있음

        //Bottomnav 본격적 연동
        viewBinding.navBottom.run{
            setOnItemSelectedListener {
                when (it.itemId) {
                    //menu에 있는 id들
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_message -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, MessageFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_home
        }




    }
}