package com.eunjeong.pizzaorderapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eunjeong.pizzaorderapp.fragments.ChikenStoreListFragment
import com.eunjeong.pizzaorderapp.fragments.PizzaStoreListFragment

class MainViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
             0 -> "피자"
            else -> "치킨"
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> PizzaStoreListFragment()
            else -> ChikenStoreListFragment()
        }
    }


}