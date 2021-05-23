package com.example.roomdatabaseass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseass.databinding.ContactViewBinding
import com.example.roomdatabaseass.db.entity.ContactEntity
import kotlinx.coroutines.flow.asFlow

class MainAdapter (): RecyclerView.Adapter<MainAdapter.ContactViewHolder>() {

    private var contacts= listOf<ContactEntity>()


    fun setupContact(list:List<ContactEntity>){
        this.contacts = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ContactViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ContactViewHolder(private val binding:ContactViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(contact: ContactEntity){
            binding.name.text = contact.name
            binding.number.text = contact.number
            binding.imageButton.text = contact.name[0].toString().toUpperCase()
        }
    }

}