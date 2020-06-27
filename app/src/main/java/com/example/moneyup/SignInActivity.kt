package com.example.moneyup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()

        val signUpBtn: Button = findViewById(R.id.appSignIn)
        signUpBtn.setOnClickListener { onBackPressed() }
    }
}
