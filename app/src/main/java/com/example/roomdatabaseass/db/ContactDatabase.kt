package com.example.roomdatabaseass.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabaseass.db.dao.ContactDao
import com.example.roomdatabaseass.db.dao.UserDao
import com.example.roomdatabaseass.db.entity.ContactEntity
import com.example.roomdatabaseass.db.entity.UserEntity

@Database(entities = [UserEntity::class, ContactEntity::class],version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun contactDao(): ContactDao

    companion object{
        @Volatile
        private var INSTANCE:ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase {
            return (INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "user_contact_database"
                ).build()
                INSTANCE = instance
                instance
            })
        }

    }


}