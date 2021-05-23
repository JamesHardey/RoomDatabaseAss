package com.example.roomdatabaseass

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomdatabaseass.db.ContactDatabase
import com.example.roomdatabaseass.db.dao.ContactDao
import com.example.roomdatabaseass.db.dao.UserDao
import com.example.roomdatabaseass.db.entity.ContactEntity
import com.example.roomdatabaseass.db.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class Repository(context: Context) {

    private val db = ContactDatabase.getDatabase(context)
    private val contactDao: ContactDao =db.contactDao()
    private val userDao: UserDao =db.userDao()


    fun getAllUsers():LiveData<List<UserEntity>> = userDao.getAllUsers()

    fun getAllContactByEmail(email:String):LiveData<List<ContactEntity>>
            = contactDao.getAllContactsByEmail(email)

    fun addContact(contactEntity: ContactEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                contactDao.addContact(contactEntity)
            }
        }
    }

    fun addUser(userEntity: UserEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                userDao.insertUser(userEntity)
            }
        }
    }



    fun getUserByEmail(email: String):UserEntity? {
        var user:UserEntity?=null
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                user = userDao.getUserByEmail(email)
            }
        }
        return user
    }



    fun deleteUser(user:UserEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                userDao.deleteUser(user)
            }
        }
    }


    fun updateUser(user:UserEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                userDao.updateUser(user)
            }
        }
    }

    fun deleteContact(contact:ContactEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                contactDao.deleteContact(contact)
            }
        }
    }

}

