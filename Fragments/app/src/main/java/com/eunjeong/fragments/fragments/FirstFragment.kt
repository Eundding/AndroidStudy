package com.eunjeong.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eunjeong.fragments.R
import com.eunjeong.fragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment(){
    private lateinit var viewBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.changeTextBtn.setOnClickListener {
            //임시로 -> 문구 바꾸기
            viewBinding.contentTxt.text = "안녕하세요"
        }

    }

}