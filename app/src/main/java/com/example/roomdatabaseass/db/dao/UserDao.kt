package com.example.roomdatabaseass.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabaseass.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertUser(user:UserEntity):Boolean

    @Query("SELECT EXIST()")
    fun checkIfUserExist(user: UserEntity):Boolean
}