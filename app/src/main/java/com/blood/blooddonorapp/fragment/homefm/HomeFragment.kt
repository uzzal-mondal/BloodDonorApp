package com.blood.blooddonorapp.fragment.homefm

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blood.blooddonorapp.R
import com.blood.blooddonorapp.databinding.FragmentHomeBinding
import com.blood.blooddonorapp.db.BloodUserDataBase
import com.blood.blooddonorapp.db.Data
import com.blood.blooddonorapp.viewmodel.MainViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var list = listOf<Data>()
    private lateinit var dataList: List<Data>
   // private val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
   private val viewModel: MainViewModel by activityViewModels<MainViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* list = BloodUserDataBase.getInstance(activity!!)
            .getDao().getAllUserDataList()*/

       /* viewModel.getData(requireContext()).observe(this) {
            binding.recyclerView.adapter = HomeListAdapter(activity!!, it)
        }*/

        viewModel.getData(requireContext()).observe(this) {
            binding.recyclerView.adapter = HomeListAdapter(activity!!, it)
        }
        inItRecyclerManage()

    }

    private fun inItRecyclerManage() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity!!)
        binding.recyclerView.adapter = HomeListAdapter(activity!!, list)
        //recyclerViews.adapter?.notifyDataSetChanged()
    }


}