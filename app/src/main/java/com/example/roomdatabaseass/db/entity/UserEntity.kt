package com.example.roomdatabaseass.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName="user",
    foreignKeys =[ForeignKey(
        entity = ContactEntity::class,
        parentColumns =["email"],
        childColumns = ["email"] )]
)

data class UserEntity(
    @PrimaryKey
    val email: String,
    val name:String,
    val password:String,
)