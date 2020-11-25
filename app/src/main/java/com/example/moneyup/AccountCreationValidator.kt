package com.example.moneyup

import android.app.Activity
import android.content.Context
import android.widget.Toast

class AccountCreationValidator {

    private lateinit var username: String
    private lateinit var password: String
    private val minUsernameLength = 8
    private val minPasswordLength = 10

    fun usernameCheck(username: String): String {
        var errorMessage: String = ""
        if(username.isEmpty()){
            errorMessage = "Please fill in your username"
            return errorMessage
        }
        if(username.length < minUsernameLength){
            errorMessage = "Username is too short. The minimum characters required are ${minUsernameLength}."
            return errorMessage
        }
        return errorMessage
    }

    fun passwordCheck(password: String): String {
        var errorMessage: String = ""
        if(password.isEmpty()){
            errorMessage = "Please fill in your password"
            return errorMessage
        } else if(password.length < minPasswordLength){
            errorMessage = "Password is too short. The minimum characters required are ${minPasswordLength}."
            return errorMessage
        }
        return errorMessage
    }


}