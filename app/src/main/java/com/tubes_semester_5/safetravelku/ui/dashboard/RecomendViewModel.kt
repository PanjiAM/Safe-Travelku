package com.tubes_semester_5.safetravelku.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecomendViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recomend Fragment"
    }
    val text: LiveData<String> = _text
}