package com.tubes_semester_5.safetravelku.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tubes_semester_5.safetravelku.R
import com.tubes_semester_5.safetravelku.ui.notifications.SerchViewModel

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: SerchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(SerchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_serch, container, false)
        val textView: TextView = root.findViewById(R.id.text_serch)
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}