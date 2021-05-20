package com.example.roomdatabaseass.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabaseass.db.entity.ContactEntity

@Dao
interface ContactDao {
    @Query("SELECT name,number FROM contacts WHERE email=:email  ")
    fun getAllContactsByEmail(email:String):LiveData<List<ContactEntity>>

    @Insert
    fun addContact(email: String,contactName:String,contactNumber:String):Boolean
}