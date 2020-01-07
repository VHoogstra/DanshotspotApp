package com.example.danshotspotapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "eventTable")
data class Event(
    @SerializedName("name")
    @ColumnInfo(name = "title")
    var title: String,

    @SerializedName("date")
    @ColumnInfo(name = "date")
    var date: Long,

    @SerializedName("location")
    @ColumnInfo(name = "location")
    var location: String,

    @SerializedName("id")
    @ColumnInfo(name = "dhs_id")
    var dhs_id: Long? = null,

    @SerializedName("id_s")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable