package com.tubes_semester_5.safetravelku.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tubes_semester_5.safetravelku.MasukActivity
import com.tubes_semester_5.safetravelku.R
import com.tubes_semester_5.safetravelku.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentProfileBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        auth = FirebaseAuth.getInstance()
        auth = Firebase.auth
        updateUI()
        return view
    }

    private fun updateUI() {
        val currentUser = auth.currentUser
        binding.textEmail.setText(currentUser?.email.toString())
        binding.textNama.setText(currentUser?.displayName.toString())
        binding.textHp.setText("No telp belum di-set!")
    }

}