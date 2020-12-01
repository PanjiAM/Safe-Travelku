package com.tubes_semester_5.safetravelku

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ScrollingDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_code"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val judul = intent.getStringExtra(EXTRA_NAMA)
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = judul.toString()

    }
}