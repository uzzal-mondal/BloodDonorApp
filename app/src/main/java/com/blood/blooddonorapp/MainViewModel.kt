package com.blood.blooddonorapp

import com.blood.blooddonorapp.db.BloodUserDataBase.Companion.getInstance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import android.app.Activity
import androidx.lifecycle.LiveData
import com.blood.blooddonorapp.db.BloodUserDataBase
import com.blood.blooddonorapp.db.Data

class MainViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<Long> = MutableLiveData()
    fun getData(activity: Activity?, data: Data?): LiveData<Long> {
      //  if (mutableLiveData == null) {
            mutableLiveData.postValue(getInstance(activity!!).getDao().insertNewUserData(data!!))
       // }
        return mutableLiveData
    }
}