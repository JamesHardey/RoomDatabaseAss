package com.example.roomdatabaseass.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="contacts")
data class ContactEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val email:String,
    val name:String,
    val number:String
)