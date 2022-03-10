package com.blood.blooddonorapp.fragment.homefm

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.blood.blooddonorapp.R
import com.blood.blooddonorapp.databinding.ItemUserListLayoutBinding
import com.blood.blooddonorapp.db.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * Created by Android Dev on 05-Mar-22 Mar, 2022
 */
class HomeListAdapter(
    val context: Activity, private val dataList: List<Data>

) :
    RecyclerView.Adapter<HomeListAdapter.MyListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ItemUserListLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.binding.profileImage.setImageResource(dataList[position].bdImageProfile)
        holder.binding.imageMap.setImageResource(dataList[position].bdImageMap)
        holder.binding.imageOptionMn.setImageResource(dataList[position].bdImageOptionMn)
        holder.binding.textTitle.text = dataList[position].bdDonorName
        holder.binding.textMdt.text = dataList[position].bdDonorDateTime
        holder.binding.textPatientPb.text = dataList[position].bdPatientPb
        holder.binding.textBloodGp.text = dataList[position].bdBloodGp
        holder.binding.textBloodAmount.text = dataList[position].bdBloodAmount
        holder.binding.textDateTimeDay.text = dataList[position].bdDateTimeDay
        holder.binding.textTime.text = dataList[position].bdTime
        holder.binding.textPlace.text = dataList[position].bdPlace
        holder.binding.textContact.text = dataList[position].bdContact

        holder.binding.imageMap.setOnClickListener {
            showDialogMap()
        }

        holder.binding.imageOptionMn.setOnClickListener {
            popupMenus(it)
        }

    }

    override fun getItemCount() = dataList.size

    inner class MyListViewHolder(val binding: ItemUserListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    @SuppressLint("DiscouragedPrivateApi")
    private fun popupMenus(v: View) {
        val popupMenus = PopupMenu(context, v)
        popupMenus.inflate(R.menu.item_option_menu)
        popupMenus.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.editText -> {
                    showUserDetailsDialog()
                    true
                }

                R.id.deleteText -> {
                    showDeleteUserDialog()
                    true
                }
                else -> true
            }
        }
        popupMenus.show()
        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val menu = popup.get(popupMenus)
        menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
            .invoke(menu, true)
    }


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

    private fun showDeleteUserDialog() {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.delete_app_title)
        builder.setMessage(R.string.delete_app_message)
        builder.setIcon(R.drawable.ic_info)

        builder.setPositiveButton(context.getString(R.string.dialog_yes)) { _, _ ->
            Toast.makeText(context, " yes", Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton(context.getString(R.string.dialog_cancel)) { _, _ ->
            Toast.makeText(context, "cancel", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}


