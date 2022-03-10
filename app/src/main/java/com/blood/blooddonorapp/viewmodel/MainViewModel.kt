package com.blood.blooddonorapp.viewmodel

import com.blood.blooddonorapp.db.BloodUserDataBase.Companion.getInstance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import android.app.Activity
import android.content.Context
import androidx.lifecycle.LiveData
import com.blood.blooddonorapp.db.BloodUserDataBase
import com.blood.blooddonorapp.db.Data

class MainViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<Long> = MutableLiveData()
    fun insertData(activity: Activity?, data: Data?): LiveData<Long> {
      //  if (mutableLiveData == null) {
            mutableLiveData.postValue(getInstance(activity!!).getDao().insertNewUserData(data!!))
       // }
        return mutableLiveData
    }

    fun getData(context: Context): LiveData<List<Data>> {
        return getInstance(context).getDao().getAllUserDataList()
    }
}