package com.tubes_semester_5.safetravelku

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
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
        const val EXTRA_KATEGORI = "extra_kategori"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_JAM = "extra_jam"
        const val EXTRA_TARIF = "extra_tarif"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val moveToMaps = Intent(this, MapsActivity::class.java)
            startActivity(moveToMaps)
        }
        val judul = intent.getStringExtra(EXTRA_NAMA)
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = judul.toString()

        val judul2 = intent.getStringExtra(EXTRA_NAMA)
        val tvjudul2 = findViewById<TextView>(R.id.item_judul2)
        tvjudul2.text = judul2

        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val tvDetail = findViewById<TextView>(R.id.item_deskripsi_wisata)
        tvDetail.text = detail

        val kategori = intent.getStringExtra(EXTRA_KATEGORI)
        val tvkategori = findViewById<TextView>(R.id.item_kategori)
        tvkategori.text = kategori

        val rating = intent.getStringExtra(EXTRA_RATING)
        val tvrating = findViewById<TextView>(R.id.item_rating)
        tvrating.text = rating

        val jam = intent.getStringExtra(EXTRA_JAM)
        val tvjam = findViewById<TextView>(R.id.item_jam)
        tvjam.text = jam

        val tarif = intent.getStringExtra(EXTRA_TARIF)
        val tvtarif = findViewById<TextView>(R.id.item_tarif)
        tvtarif.text = tarif

        val img = intent.getIntExtra(EXTRA_IMAGE,1)
        val imgBanner = findViewById<ImageView>(R.id.iv_detail_photo)
        imgBanner.setImageResource(img)
    }
}