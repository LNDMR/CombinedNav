package com.syntax.koetter.combinednav.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syntax.koetter.combinednav.databinding.FragmentPersonaldataBinding

class PersonalDataFragment: Fragment() {

    private lateinit var binding: FragmentPersonaldataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // dataBinding + inflate
        binding = FragmentPersonaldataBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // bind + nav
    }
}