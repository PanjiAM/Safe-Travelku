package com.tubes_semester_5.safetravelku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tubes_semester_5.safetravelku.R
import com.tubes_semester_5.safetravelku.ScrollingDetailActivity
import java.util.*
import kotlin.collections.ArrayList


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemNama: TextView
        var itemKategori: TextView
        var itemDetail: TextView
        var itemRating: TextView
        var itemJam: TextView
        var itemTarif: TextView
        var fotoObjek: ImageView
        var drawableImg : Int ? = null

        init {
            itemNama = itemView.findViewById(R.id.namaWisata)
            itemKategori = itemView.findViewById(R.id.kategori)
            itemDetail = itemView.findViewById(R.id.detailWisata)
            itemRating = itemView.findViewById(R.id.ratingWisata)
            itemJam = itemView.findViewById(R.id.jamWisata)
            itemTarif = itemView.findViewById(R.id.tarifWisata)
            fotoObjek = itemView.findViewById(R.id.img_item_photo)


            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, ScrollingDetailActivity::class.java).apply {
                    putExtra(ScrollingDetailActivity.EXTRA_NAMA, itemNama.text)
                    putExtra(ScrollingDetailActivity.EXTRA_DETAIL, itemDetail.text)
                    putExtra(ScrollingDetailActivity.EXTRA_KATEGORI, itemKategori.text)
                    putExtra(ScrollingDetailActivity.EXTRA_RATING, itemRating.text)
                    putExtra(ScrollingDetailActivity.EXTRA_JAM, itemJam.text)
                    putExtra(ScrollingDetailActivity.EXTRA_TARIF, itemTarif.text)
                    putExtra(ScrollingDetailActivity.EXTRA_IMAGE, drawableImg)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_wisata, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemNama.text = nama[i]
        viewHolder.itemKategori.text = kategori[i]
        viewHolder.itemRating.text = rating[i]
        viewHolder.itemJam.text = jam[i]
        viewHolder.itemTarif.text = tarif[i]
        viewHolder.itemDetail.text = detail[i]
        viewHolder.fotoObjek.setImageResource(img[i])
        viewHolder.drawableImg = img[i]

    }
    override fun getItemCount(): Int {
        return nama.size
        return kategori.size
        return rating.size
        return jam.size
        return tarif.size
        return detail.size
    }

    private val nama = arrayOf("Kebun Bunga Matahari",
        "Bukit Pandang Munggang", "Sendang Bidadari", "Bukit Watu Meja",
        "Bukit Agaran", "Bukit Gadog", "Baturraden",
        "Curug Jenggala")

    private val img = arrayOf(
            R.drawable.kebun_matahari,
            R.drawable.bukit_pandang_munggang,
            R.drawable.sendang_bidadari,
            R.drawable.bukit_watu_meja,
            R.drawable.agaran,
            R.drawable.bukit_gadog,
            R.drawable.baturaden1,
            R.drawable.curug_jenggala
    )

    private val kategori = arrayOf("Wisata Alam", "Wisata Alam, Pegunungan",
        "Wisata Alam, Air", "Wisata Alam",
        "Wisata Alam", "Wisata Alam",
        "Wisata Alam, Rekreasi", "Wisata Alam, Air")

    private val detail = arrayOf("Yang tertarik menikmati warna-warna cerah bunga matahari dan marigold, kebun bunga ini adalah spot yang tepat dikunjungi. Kamu dipersilakan berburu foto yang Instagenik, tapi jangan sampai merusak kebun bunganya, ya!",
        "Tidak bisa dimungkiri, Bukit Pandang Munggang menjadi destinasi wisata di Banyumas yang harus kamu kunjungi jika ingin melihat keindahan alam dan lanskap yang keren dari kota ini. Tidak hanya itu saja, banyak spot berfoto kece yang bisa jadi pilihan background kamu, terutama saat malam hari!",
        "Ingin tahu seperti apa kolam mandinya para bidadari? Sendang Bidadari di seputaran wilayah Curug Telu setidaknya menggambarkan nuansa dan suasana kolam tersebut. View yang eksotik dengan atmosfer yang hening dijamin akan memesona kamu!",
        "Bayangkan, dari destinasi wisata di Banyumas ini, kamu akan mendapati lukisan alam dalam bentuk 3D yang luar biasa! Perpaduan perbukitan yang hijau di kejauhan, aliran sungai dan langit biru sebagai latar, sungguh view yang istimewa!",
        "Jogja memiliki Hutan Pinus Pengger yang begitu ngehits, sementara Banyumas memiliki Bukit Agaran yang tidak kalah menariknya. Tangan raksasa sebagai spot foto, dengan background alam yang keren, pun terdapat di sini, dan pastinya bisa menjadi salah satu alasan untuk datang ke sini.",
        "Penikmat selfie, Bukit Gadog bisa menjadi destinasi wisata di Purwokerto yang pas untuk dikunjungi. Meski sedikit menantang untuk didatangi, namun pesona alam yang kamu dapatkan di puncaknya akan membuat siapapun terkesima.",
        "Wisata Baturaden merupakan tempat wisata yang berada di sebelah utara Kota Purwokerto atau tepatnya di lereng gunung slamet. tidak sedikit hotel dan vila indah berdiri di kawasan ini untuk memenuhi kebutuhan tempat tinggal di kawasan baturaden, dengan hawa yang sejuk dan pemandangan yang indah membuat wisatawan betah untuk tinggal di setiap hotel maupun vila yang ada di sini.",
        "Curug Jenggal adalah air terjun setinggi kurang lebih 30 meter yang berada di Banyumas. Air terjun ini merupakan salah satu rangkaian air terjun yang berada di kawasan Gunung Slamet. Sebelumnya, Curug Jenggala memiliki nama Curug Tempuan, mewakili kondisinya yang menjadi pertemuan Sungai Banjaran dan Sungai Mertelu.")

    private val rating = arrayOf("4.3", "4.4",
        "4.0", "3.9",
        "3.7",
        "4.6", "4.7", "4.9")

    private val jam = arrayOf("06.00 - 18.00", "08.00 - 21.00",
        "24 Jam", "08.00 - 18.00",
        "08.00 - 17.00", "24 jam",
        "07.00 - 15.00", "07.00 - 17.00")

    private val tarif = arrayOf("Rp8000,- / Orang", "Rp10000,- / Orang",
        "Rp3000,- / Orang", "Rp5000,- / Orang",
        "Rp5000,- / Orang", "Rp5000,- / Orang",
        "Rp25000,- / Orang", "Rp8000,- / Orang")

}

