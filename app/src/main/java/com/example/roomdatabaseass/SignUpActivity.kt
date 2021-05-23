package com.example.roomdatabaseass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import com.example.roomdatabaseass.db.entity.UserEntity
import com.google.android.material.textfield.TextInputEditText
import java.net.PasswordAuthentication

class SignUpActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private lateinit var email: TextInputEditText
    private lateinit var password1: TextInputEditText
    private lateinit var name: TextInputEditText
    private lateinit var password2: TextInputEditText
    private lateinit var register: Button
    private lateinit var textview:TextView
    private lateinit var imageview:ImageView
    private lateinit var loginIntent :Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        repository = Repository(this)
        loginIntent = Intent(this@SignUpActivity, LoginActivity::class.java)

        email = findViewById(R.id.editTextEmail)
        name = findViewById(R.id.editTextName)
        password1 = findViewById(R.id.password)
        password2 = findViewById(R.id.editTextPassword)
        register = findViewById(R.id.cirRegisterButton)
        textview= findViewById(R.id.textview)
        imageview = findViewById(R.id.imageview)

        imageview.setOnClickListener {
            click()
        }
        textview.setOnClickListener{
            click()
        }



        //repository.addUser(UserEntity("james@yahoo.com","James","1234"))
        repository.getAllUsers().observe(this, { list ->

            Log.d("Name", list[0].email.toString())
        })

        register.setOnClickListener {
            register()
        }
    }

    private fun checkIfValid(email: TextInputEditText): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
    }

    private fun click() {
        startActivity(loginIntent)
    }


    private fun checkIfExist(email: String):Boolean {

        return false
    }

    private fun confirmPassMatch(pass1: String, pass2: String): Boolean {
        return pass1 == pass2
    }

    private fun confirmNotEmpty(): Boolean {

        return (email.toString().isEmpty() or
            name.toString().isEmpty() or
            password1.toString().isEmpty() or
            password2.toString().isEmpty()
        )


    }

    private fun addUser(user:UserEntity){
        repository.addUser(user)
    }

    private fun register(){
        if(!confirmNotEmpty()){
            if(checkIfValid(email)){
                if(!checkIfExist(email.toString())){
                    if(confirmPassMatch(password1.toString(),password2.toString())){
                        addUser(
                            UserEntity(
                                email.toString(),
                                name.toString(),
                                password1.toString()
                            )
                        )
                        click()
                    }
                    else{
                        display("Passwords doesnt match")
                    }
                }
                else{
                    display("Email Already Exist")
                }
            }
            else{
                display("Invalid Email Address")
            }
        }
        else{
            display("Fields must not be empty")
        }
    }

    private fun display(str:String){
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show()
    }


}