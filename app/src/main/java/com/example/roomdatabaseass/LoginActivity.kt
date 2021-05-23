package com.example.roomdatabaseass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {
    private lateinit var email:TextInputEditText
    private lateinit var pass:TextInputEditText
    private lateinit var loginBtn: Button
    private val repository = Repository(this)
    private lateinit var mainIntent:Intent
    private var confirm:Boolean? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mainIntent= Intent(this@LoginActivity,MainActivity::class.java)

        email = findViewById(R.id.textEmail)
        pass = findViewById(R.id.textPassword)
        loginBtn = findViewById(R.id.cirLoginButton)

        loginBtn.setOnClickListener {

            while(confirm==null){
                loginBtn.isEnabled=checkUser()
            }




        }

    }

    private fun checkUser():Boolean{
        val myEmail = email.text.toString()
        val myPass = pass.text.toString()
        val user =repository.getUserByEmail(myEmail)

        return if(user!=null){
            if((user.email.equals(myEmail,false)) and (user.password==myPass) ){
                display("Login Successful")
                confirm=true
                true
            } else{
                display("Incorrect Password or Email")
                confirm=false
                false
            }
        }
        else{
            display("Unknown Email address")
            confirm=false
            false
        }


    }

    private fun login(email1:TextInputEditText){
        val email = email1.text.toString()
        mainIntent.putExtra("email",email)
        startActivity(mainIntent)
    }

    private fun click(){
        onBackPressed()
    }

    private fun display(str:String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }

}
