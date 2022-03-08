package com.blood.blooddonorapp.db

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Android Dev on 05-Mar-22 Mar, 2022
 */
@Entity(tableName = "tbl_blood")
class Data : Serializable {
    @Ignore
    var bdImageProfile = 0

    @Ignore
    var bdImageMap = 0

    @Ignore
    var bdImageOptionMn = 0

    @Ignore
    var bdDonorDateTime: String? = null


    @PrimaryKey(autoGenerate = true)
    private var _id: Long = 0
    var bdDonorName: String? = null
    var bdPatientPb: String? = null
    var bdBloodGp: String? = null
    var bdBloodAmount: String? = null
    var bdDateTimeDay: String? = null
    var bdTime: String? = null
    var bdPlace: String? = null
    var bdContact: String? = null


    @Ignore
    constructor(
        bdImageProfile: Int,
        bdImageMap: Int,
        bdImageOptionMn: Int,
        bdDonorDateTime: String?,
        bdDonorName: String?,
        bdPatientPb: String?,
        bdBloodGp: String?,
        bdBloodAmount: String?,
        bdDateTimeDay: String?,
        bdTime: String?,
        bdPlace: String?,
        bdContact: String?
    ) {
        this.bdImageProfile = bdImageProfile
        this.bdImageMap = bdImageMap
        this.bdImageOptionMn = bdImageOptionMn
        this.bdDonorDateTime = bdDonorDateTime
        this.bdDonorName = bdDonorName
        this.bdPatientPb = bdPatientPb
        this.bdBloodGp = bdBloodGp
        this.bdBloodAmount = bdBloodAmount
        this.bdDateTimeDay = bdDateTimeDay
        this.bdTime = bdTime
        this.bdPlace = bdPlace
        this.bdContact = bdContact
    }

    /**
     * room db constructor..
     */
    constructor(
        bdDonorName: String?,
        bdPatientPb: String?,
        bdBloodGp: String?,
        bdBloodAmount: String?,
        bdDateTimeDay: String?,
        bdTime: String?,
        bdPlace: String?,
        bdContact: String?
    ) {
        this.bdDonorName = bdDonorName
        this.bdPatientPb = bdPatientPb
        this.bdBloodGp = bdBloodGp
        this.bdBloodAmount = bdBloodAmount
        this.bdDateTimeDay = bdDateTimeDay
        this.bdTime = bdTime
        this.bdPlace = bdPlace
        this.bdContact = bdContact
    }


    fun get_id(): Long {
        return _id
    }

    fun set_id(_id: Long) {
        this._id = _id
    }
}