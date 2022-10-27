package com.example.umc_week5

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_week5.databinding.ItemDataBinding

class DataRVAdapter(private val dataList:ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
    //Mission
    private val checkboxStatus = SparseBooleanArray() //정수 값들을 boolean 값들로 매핑시키는 기능


    // ViewHolder 객체
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: Data){
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc

            //mission 추가
            viewBinding.swcData.isChecked = checkboxStatus[adapterPosition]
            viewBinding.swcData.setOnClickListener{
                if(!viewBinding.swcData.isChecked)
                    checkboxStatus.put(adapterPosition, false)
                else
                    checkboxStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }


        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    //ViewHolder가 실제로 데이터를 표시해야할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    // 표현할 Item의 총 갯수
    override fun getItemCount(): Int = dataList.size
}