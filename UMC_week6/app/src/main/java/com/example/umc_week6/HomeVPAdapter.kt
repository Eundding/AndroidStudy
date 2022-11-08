package com.example.umc_week6

import android.app.PendingIntent.getActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

//var activity = getActivity() as MainActivity
//class HomeVPAdapter(fragmentActivity: HomeFragment): FragmentStateAdapter(fragmentActivity) {
class HomeVPAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItemCount(): Int = 3 // 총 아이템 개수

    override fun createFragment(position: Int): Fragment { //position에 따라 어떤 frag 보여줄지
        return when (position){
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }


}


