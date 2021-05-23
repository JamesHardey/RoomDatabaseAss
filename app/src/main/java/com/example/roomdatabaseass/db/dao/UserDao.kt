package com.example.roomdatabaseass.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabaseass.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert()
    fun insertUser(user:UserEntity)


    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE email =:email")
    fun getUserByEmail(email:String):UserEntity?

    @Update
    fun updateUser(user:UserEntity)

    @Delete
    fun deleteUser(user:UserEntity)
}