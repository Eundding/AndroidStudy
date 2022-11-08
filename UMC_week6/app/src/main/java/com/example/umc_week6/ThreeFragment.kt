package com.example.umc_week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_week6.databinding.FragmentOneBinding
import com.example.umc_week6.databinding.FragmentThreeBinding
import com.example.umc_week6.databinding.FragmentTwoBinding


class ThreeFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentThreeBinding.inflate(layoutInflater).root
    }
}