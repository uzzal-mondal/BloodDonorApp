package com.blood.blooddonorapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Android Dev on 08-Mar-22 Mar, 2022
 */

@Database(entities = [Data::class], version = 1)
abstract class BloodUserDataBase : RoomDatabase() {
    abstract fun getDao(): BloodUserDao

    companion object {
        private lateinit var dataBase: BloodUserDataBase
        fun getInstance(context: Context): BloodUserDataBase {
            //check in null safety.
            dataBase = Room.databaseBuilder(context, BloodUserDataBase::class.java, "blood_db")
                .allowMainThreadQueries()
                .build()
            return dataBase
        }
    }
}