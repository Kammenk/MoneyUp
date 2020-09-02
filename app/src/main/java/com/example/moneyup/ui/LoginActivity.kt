package com.example.moneyup.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moneyup.AccountCreationValidator
import com.example.moneyup.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class LoginActivity : AppCompatActivity() {

    private val signUpUsername by lazy {findViewById<EditText>(R.id.signUpUsername)}
    private val signUpPassword by lazy {findViewById<EditText>(R.id.signUpPassword)}
    private val usernameErrorMessage by lazy {findViewById<TextView>(R.id.usernameErrorMessage)}
    private val passwordErrorMessage by lazy {findViewById<TextView>(R.id.passwordErrorMessage)}
    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val signInButton = findViewById<ImageButton>(R.id.sign_in_button)

        signInButton.setOnClickListener{
            val signInIntent = mGoogleSignInClient.getSignInIntent()
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...)
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult()
        }
    }

    private fun handleSignInResult() {
        try {

        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(FragmentActivity.TAG, "signInResult:failed code=" + e.statusCode)
        }
    }

     fun moveToSignInPage(view: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    fun createAccount(view: View) {
        val username = signUpUsername.text.toString()
        val password = signUpPassword.text.toString()
        val usernameValid: Boolean
        val passwordValid: Boolean
        val accountChecker = AccountCreationValidator()
        val usernameValidationStr = accountChecker.usernameCheck(username)
        val passwordValidationStr = accountChecker.passwordCheck(password)

        if(usernameValidationStr == ""){
            usernameErrorMessage.visibility = View.GONE
            usernameValid = true
        } else {
            usernameValid = false
            usernameErrorMessage.visibility = View.VISIBLE
            usernameErrorMessage.text = usernameValidationStr
        }

        if(passwordValidationStr == ""){
            passwordErrorMessage.visibility = View.GONE
            passwordValid = true
        } else {
            passwordValid = false
            passwordErrorMessage.visibility = View.VISIBLE
            passwordErrorMessage.text = passwordValidationStr
        }

        if(usernameValid && passwordValid){
            val intent = Intent(this, WrapperActivity::class.java)
            startActivity(intent)

        }
    }
}
