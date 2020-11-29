package com.tubes_semester_5.safetravelku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        supportActionBar?.hide()
    }
}