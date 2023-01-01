package com.eunjeong.viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eunjeong.viewpager.fragments.FirstFragment
import com.eunjeong.viewpager.fragments.SecondFragment
import com.eunjeong.viewpager.fragments.ThirdFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3 // 몇장짜리인지
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0){
            return FirstFragment()
        }
        else if (position == 1){
            return SecondFragment()
        }
        else{
            return ThirdFragment()
        }
    }

}