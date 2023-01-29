package com.example.cf_prob.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cf_prob.Model_classes.problems


@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact:problems)

    @Update
    suspend fun updateContact(contact:problems)

    @Delete
    suspend fun deleteContact(contact:problems)
    @Query("DELETE  FROM contact")
    fun delete_complete()
    @Query("SELECT * FROM contact")
     fun getContact(): LiveData<List<problems>>
}