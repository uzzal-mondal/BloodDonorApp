package com.blood.blooddonorapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.blood.blooddonorapp.db.Data

/**
 * Created by Android Dev on 08-Mar-22 Mar, 2022
 */

@Dao
interface BloodUserDao {

    @Insert
    fun insertNewUserData(data: Data): Long

    @Delete
    fun deleteUserData(data: Data): Int

    @Update
    fun updateUserData(data: Data): Int

    @Query("select * from tbl_blood")
    fun getAllUserDataList(): LiveData<List<Data>>

}