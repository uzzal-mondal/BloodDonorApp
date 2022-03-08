package com.blood.blooddonorapp.db.dao.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Android Dev on 08-Mar-22 Mar, 2022
 */

@Database(entities = [Data::class], version = 1)
abstract class BloodUserDB : RoomDatabase() {
    abstract fun getDao(): BloodUserDao

    companion object{
        private lateinit var db:BloodUserDB
        fun getInstance(context: Context):BloodUserDB{
            db = Room.databaseBuilder(context, BloodUserDB::class.java,"blood_db")
                .allowMainThreadQueries()
                .build()
            return db
        }
    }
}