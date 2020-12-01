package com.tubes_semester_5.safetravelku.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SerchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is serch Fragment"
    }
    val text: LiveData<String> = _text
}