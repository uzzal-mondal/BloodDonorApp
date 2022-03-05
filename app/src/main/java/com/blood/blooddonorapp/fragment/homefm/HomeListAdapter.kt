package com.blood.blooddonorapp.fragment.homefm

import android.app.Activity
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blood.blooddonorapp.databinding.ItemDetailsLayoutBinding


/**
 * Created by Android Dev on 05-Mar-22 Mar, 2022
 */
class HomeListAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<HomeListAdapter.MyListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ItemDetailsLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.binding.profileImage.setImageResource(dataList[position].imageProfile)
        holder.binding.imageMap.setImageResource(dataList[position].imageMap)
        holder.binding.textTitle.text = dataList[position].donorName
        holder.binding.textMdt.text = dataList[position].donorDateTime
        holder.binding.textPatientPb.text = dataList[position].patientPb
        holder.binding.textBloodGp.text = dataList[position].bloodGp
        holder.binding.textBloodAmount.text = dataList[position].bloodAmount
        holder.binding.textDateTimeDay.text = dataList[position].dateTimeDay
        holder.binding.textTime.text = dataList[position].time
        holder.binding.textPlace.text = dataList[position].place
        holder.binding.textContact.text = dataList[position].contact

    }

    override fun getItemCount() = dataList.size

    inner class MyListViewHolder(val binding: ItemDetailsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}
