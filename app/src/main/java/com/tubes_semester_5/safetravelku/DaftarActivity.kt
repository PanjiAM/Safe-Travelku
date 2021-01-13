package com.tubes_semester_5.safetravelku

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        val btn = findViewById<Button>(R.id.daftar)
        btn.setOnClickListener(View.OnClickListener {
            val user = findViewById<EditText>(R.id.username)
            val inuser = user.text.toString()
            val pass = findViewById<EditText>(R.id.password)
            val inpass = pass.text.toString()
            Log.d("SignUp", "Email is" + inuser)
            Log.d("SignUp", "Password:$inpass")
            if (inuser.isEmpty() || inpass.isEmpty()) {
                Toast.makeText(this, "Masukan Email dan Password", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val progressDialog = ProgressDialog(
                this,
                R.style.Theme_MaterialComponents_Light_Dialog
            )
            progressDialog.isIndeterminate = true
            progressDialog.setMessage("Proses Mendaftar...")
            progressDialog.show()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(inuser, inpass)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                        val intent = Intent(this, DaftarActivity::class.java)
                        startActivity(intent)
                    } else
                        Log.d(
                            "Sign Up",
                            "Berhasil Mendaftarkan Akun dengan uid: ${it.result?.user?.uid}"
                        )
                    Toast.makeText(this, "Berhasil mendaftar akun", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MasukActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Log.d("Sign Up", "Gagal mendaftar akun${it.message}")
                    Toast.makeText(this, "Email Sudah Terdaftar", Toast.LENGTH_SHORT).show()
                    progressDialog.hide()
                }
        })
    }
}