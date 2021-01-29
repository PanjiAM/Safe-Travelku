package com.tubes_semester_5.safetravelku

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tubes_semester_5.safetravelku.databinding.ActivityMasukBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityMasukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val username: TextView = findViewById(R.id.username)
        val password: TextView = findViewById(R.id.password)
        val googleSigninBtn:SignInButton = findViewById(R.id.googleSigninBtn)

        mAuth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        googleSignInClient = GoogleSignIn.getClient(this,gso)



        googleSigninBtn.setOnClickListener{
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, 9001)
        }
        masuk.setOnClickListener {
            signInWithemail(username.text.toString(), password.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        val cUser = mAuth.currentUser
        if(cUser!==null){
            SuccessLogin()
        }
    }

    private fun signInWithemail(usernameTxt: String, passwordTxt: String) {
        if (!validateForm()) {
            return
        } else {
            mAuth.signInWithEmailAndPassword(usernameTxt, passwordTxt)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                            SuccessLogin()
                        } else {
                            password.error = "Username atau password salah"
                            username.error = "Username atau password salah"
                        }
                    }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 9001) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                val view = binding.container
                Snackbar.make(view, "Google sign in failed.",
                        Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        val view = binding.container
                        Snackbar.make(view, "Authentication Success.",
                                Snackbar.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val view = binding.container
                        Snackbar.make(view, "Authentication Failed.",
                                Snackbar.LENGTH_SHORT).show()
                    }
                }
    }

    private fun SuccessLogin(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun validateForm(): Boolean {
        var valid = true

        val usernameText = username.text.toString()
        val passwordText = password.text.toString()

        if (TextUtils.isEmpty(usernameText)) {
            username.error = "Silahkan masukkan email"
            valid = false
        } else {
            username.error = null
        }

        if (TextUtils.isEmpty(passwordText)) {
            password.error = "Silahkan masukkan password"
            valid = false

        } else {
            username.error = null
        }

        return valid

    }
}