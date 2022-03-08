package com.blood.blooddonorapp.fragment.homefm

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blood.blooddonorapp.R
import com.blood.blooddonorapp.databinding.FragmentHomeBinding
import com.blood.blooddonorapp.db.BloodUserDataBase
import com.blood.blooddonorapp.db.Data


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var listAdapter: HomeListAdapter
    var list = listOf<Data>()

    // private lateinit var homeListAdapter: HomeListAdapter
    private lateinit var dataList: List<Data>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*list = BloodUserDataBase.getInstance(context = Activity())
            .getDao().getAllUserDataList()
        listAdapter = HomeListAdapter(context = Activity(), list)*/



        showDataList()
        inItRecyclerManage()
    }

    private fun inItRecyclerManage() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = HomeListAdapter(requireActivity(), dataList )
    }

    private fun showDataList() {
        dataList = listOf(
            Data(
                R.drawable.ic_donor, R.drawable.ic_location, R.drawable.ic_more,
                "sep 17 at 1.45 pm", "SH", "Thalesia",
                "A+", "1 bag", "jul 17 at 1:45 PM",
                "9:45", "Khulna medical", "01980450700"
            ),

            Data(
                R.drawable.ic_donor, R.drawable.ic_location, R.drawable.ic_more,
                "sep 17 at 1.45 pm", "uzzal", "Thalesia",
                "A+", "1 bag", "jul 17 at 1:45 PM",
                "9:45", "Khulna medical", "01980450700"
            ),

            Data(
                R.drawable.ic_donor, R.drawable.ic_location, R.drawable.ic_more,
                "sep 17 at 1.45 pm", "suzal", "Thalesia",
                "A+", "1 bag", "jul 17 at 1:45 PM",
                "9:45", "Khulna medical", "01980450700"
            ),

            Data(
                R.drawable.ic_donor, R.drawable.ic_location, R.drawable.ic_more,
                "sep 17 at 1.45 pm", "RA", "Thalesia",
                "A+", "1 bag", "jul 17 at 1:45 PM",
                "9:45", "Khulna medical", "01980450700"
            ),



            )
    }

}