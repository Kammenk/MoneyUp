package com.example.moneyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timerTask

class LoginActivity : AppCompatActivity() {

    lateinit var signUpUsername: EditText
    lateinit var signUpPassword: EditText
    lateinit var usernameErrorMessage: TextView
    lateinit var passwordErrorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        signUpUsername = findViewById(R.id.signUpUsername)
        signUpPassword = findViewById(R.id.signUpPassword)
        usernameErrorMessage = findViewById(R.id.usernameErrorMessage)
        passwordErrorMessage = findViewById(R.id.passwordErrorMessage)


    }

     fun moveToSignInPage(view: View){
        val intent = Intent(this,SignInActivity::class.java)
        startActivity(intent)
    }

    fun createAccount(view: View){
        val username = signUpUsername.text.toString()
        val password = signUpPassword.text.toString()
        var usernameValid: Boolean = false
        var passwordValid: Boolean = false
        var accountChecker = AccountCreationValidator()
        var usernameValidationStr = accountChecker.usernameCheck(username)
        var passwordValidationStr = accountChecker.passwordCheck(password)

        if(usernameValidationStr.equals("")){
            usernameErrorMessage.visibility = View.GONE
            usernameValid = true
        } else {
            usernameValid = false
            usernameErrorMessage.visibility = View.VISIBLE
            usernameErrorMessage.text = usernameValidationStr
        }

        if(passwordValidationStr.equals("")){
            passwordErrorMessage.visibility = View.GONE
            passwordValid = true
        } else {
            passwordValid = false
            passwordErrorMessage.visibility = View.VISIBLE
            passwordErrorMessage.text = passwordValidationStr
        }

        if(usernameValid && passwordValid){
            Toast.makeText(this,"Everything is fine!",Toast.LENGTH_LONG).show()
        }
    }
}
