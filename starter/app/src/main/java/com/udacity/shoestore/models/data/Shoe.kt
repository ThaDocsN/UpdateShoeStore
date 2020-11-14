package com.udacity.shoestore.models.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "shoe_table")
data class Shoe(
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
) : Parcelable