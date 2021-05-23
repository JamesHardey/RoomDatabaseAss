package com.example.roomdatabaseass.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="contacts",foreignKeys =[ForeignKey(
    entity = UserEntity::class,
    parentColumns =["email"],
    childColumns = ["email"] )])
data class ContactEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    @ColumnInfo(index=true)
    val email:String,
    val name:String,
    val number:String
)