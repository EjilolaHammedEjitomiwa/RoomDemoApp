package com.geodeveloper.roomdemoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subscriber_data_table")
data class Subscriber(
    @ColumnInfo(name="subscriber_id")
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="subscriber_name")
    val name:String,
    @ColumnInfo(name="subscriber_email")
    val email:String
)