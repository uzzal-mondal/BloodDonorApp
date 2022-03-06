package com.blood.blooddonorapp.fragment.homefm

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater

import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.blood.blooddonorapp.R
import com.blood.blooddonorapp.databinding.ItemUserListLayoutBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * Created by Android Dev on 05-Mar-22 Mar, 2022
 */
class HomeListAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<HomeListAdapter.MyListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ItemUserListLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.binding.profileImage.setImageResource(dataList[position].imageProfile)
        holder.binding.imageMap.setImageResource(dataList[position].imageMap)
        holder.binding.imageMore.setImageResource(dataList[position].imageMore)

        holder.binding.textTitle.text = dataList[position].donorName
        holder.binding.textMdt.text = dataList[position].donorDateTime
        holder.binding.textPatientPb.text = dataList[position].patientPb
        holder.binding.textBloodGp.text = dataList[position].bloodGp
        holder.binding.textBloodAmount.text = dataList[position].bloodAmount
        holder.binding.textDateTimeDay.text = dataList[position].dateTimeDay
        holder.binding.textTime.text = dataList[position].time
        holder.binding.textPlace.text = dataList[position].place
        holder.binding.textContact.text = dataList[position].contact

        holder.binding.imageMap.setOnClickListener {
            showDialogMap()
        }

        holder.binding.imageMore.setOnClickListener {
            showUserDetailsDialog()
        }

    }



    override fun getItemCount() = dataList.size

    inner class MyListViewHolder(val binding: ItemUserListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    private fun showDialogMap() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_map)
        val btnClose = dialog.findViewById<FloatingActionButton>(R.id.fabClose)



        btnClose?.setOnClickListener {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
        val window: Window = dialog.window!!
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        if (!dialog.isShowing) {
            dialog.show()
        }
    }



    private fun showUserDetailsDialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_user_details)
        val close = dialog.findViewById<ImageView>(R.id.btn_close)


        close?.setOnClickListener {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
        val window: Window = dialog.window!!
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        if (!dialog.isShowing) {
            dialog.show()
        }

    }
}
