package com.example.roomdatabaseass.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName="user", indices = [Index(value = ["email"],
    unique = true)]
)
data class UserEntity(
    @PrimaryKey
    val email: String,
    val name:String,
    val password:String,
)