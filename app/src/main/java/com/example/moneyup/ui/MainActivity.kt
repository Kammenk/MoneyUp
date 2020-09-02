package com.example.moneyup.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneyup.R
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        moveForward()
    }

    private fun moveForward(){

        val delay: Long = 1500
        val intent = Intent(this, LoginActivity::class.java)
        Timer().schedule(delay) {
            startActivity(intent)
        }
    }
}
