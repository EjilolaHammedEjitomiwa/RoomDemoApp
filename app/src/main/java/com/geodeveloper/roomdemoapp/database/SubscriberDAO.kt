package com.geodeveloper.roomdemoapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserSubscriber(subscriber: Subscriber):Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM Subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM Subscriber_data_table")
    fun getAllSubscriber():LiveData<List<Subscriber>>




}
