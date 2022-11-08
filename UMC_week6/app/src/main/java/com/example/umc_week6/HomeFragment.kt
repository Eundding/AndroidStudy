package com.example.umc_week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_week6.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(layoutInflater).root
    }


    private val viewBinding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    //viewpager2 연동
   override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val homeVPAdapter = HomeVPAdapter(this)
        viewBinding.vpHome.adapter = homeVPAdapter

        val tabTitleArray = arrayOf(
            "one",
            "Two",
            "Three",
        )

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpHome){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach() //attach는 연결을 최종적으로 하겠다

    }

}