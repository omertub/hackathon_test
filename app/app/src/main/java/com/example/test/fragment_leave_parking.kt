package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.test.databinding.FragmentLeaveParkingBinding
import com.example.test.databinding.FragmentLoginBinding

class fragment_leave_parking : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLeaveParkingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_leave_parking, container, false)

        return binding.root
    }


}