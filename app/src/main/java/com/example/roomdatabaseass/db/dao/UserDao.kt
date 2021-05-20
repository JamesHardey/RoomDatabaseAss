package com.example.roomdatabaseass.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabaseass.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertUser(email:String,user:UserEntity)

    @Query("SELECT EXISTS(SELECT * FROM user WHERE email =:email)")
    fun checkIfUserExist(email:String):Boolean
}