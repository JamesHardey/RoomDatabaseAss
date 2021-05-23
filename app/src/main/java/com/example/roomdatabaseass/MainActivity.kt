package com.example.roomdatabaseass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseass.db.ContactDatabase
import com.example.roomdatabaseass.db.entity.ContactEntity
import com.example.roomdatabaseass.db.entity.UserEntity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private lateinit var recyclerV: RecyclerView
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_item)
        recyclerV = findViewById(R.id.contactRV)

        val bundle = intent.extras

        val email = bundle!!.getString("email")

        //val user = UserEntity("james@yahoo.com","James","james")
        //val contact = ContactEntity(email="james@yahoo.com",name="James",number="08027362734")

        recyclerV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = MainAdapter()
        recyclerV.adapter = adapter

        if (email != null) {
            repository.getAllContactByEmail(email).observe(this,{
                adapter.setupContact(it)
            })
        }

    }
}
