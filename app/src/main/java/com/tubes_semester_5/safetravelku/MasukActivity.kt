package com.tubes_semester_5.safetravelku

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
import com.tubes_semester_5.safetravelku.databinding.ActivityMasukBinding
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)
        val btn = findViewById<Button>(R.id.masuk)
        btn.setOnClickListener(View.OnClickListener {
            val user = findViewById<EditText>(R.id.username)
            val inuser = user.text.toString()
            val pass = findViewById<EditText>(R.id.password)
            val inpass = pass.text.toString()
            if (inuser.isEmpty() || inpass.isEmpty()) {
                Toast.makeText(this, "Masukan Email dan Password", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(inuser, inpass)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                        val intent = Intent(this, MasukActivity::class.java)
                        startActivity(intent)
                    } else
                        Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Log.d("Main", "Failed Login: ${it.message}")
                    Toast.makeText(this, "Email / Password Salah", Toast.LENGTH_SHORT).show()
                }
        })

    }
}
