package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.test.databinding.FragmentUserDataBinding


class fragment_user_data : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentUserDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_data, container, false)

        return binding.root
    }

}