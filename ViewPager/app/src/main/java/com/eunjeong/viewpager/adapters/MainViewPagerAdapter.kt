package com.eunjeong.viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eunjeong.viewpager.fragments.FirstFragment
import com.eunjeong.viewpager.fragments.SecondFragment
import com.eunjeong.viewpager.fragments.ThirdFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    //페이지별 제목 설정
    override fun getPageTitle(position: Int): CharSequence? {
//        if (position == 0){
//            return "첫번째"
//        }
//        else if (position == 1){
//            return "두번쨰"
//        }
//        else{
//            return "세번째"
//        }
        return when(position){
            0 -> "첫번째"
            1->"두번째"
            else -> "세번째"
        }
    }

    override fun getCount(): Int {
        return 3 // 몇장짜리인지
    }

    override fun getItem(position: Int): Fragment {
//        if (position == 0){
//            return FirstFragment()
//        }
//        else if (position == 1){
//            return SecondFragment()
//        }
//        else{
//            return ThirdFragment()
//        }
        return when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }
    }

}