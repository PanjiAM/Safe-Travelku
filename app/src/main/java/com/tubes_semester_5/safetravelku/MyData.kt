package com.tubes_semester_5.safetravelku

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
        var name: String,
        var description: String,
        var kategori: String,
        var tarif: String,
        var jam: String,
        var photo: String
) : Parcelable
