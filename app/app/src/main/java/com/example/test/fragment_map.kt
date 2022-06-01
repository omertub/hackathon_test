package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.test.R
import com.example.test.databinding.FragmentLoginBinding
import com.example.test.databinding.FragmentMapBinding

class fragment_map : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMapBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_map, container, false
        )

        return binding.root
    }
}