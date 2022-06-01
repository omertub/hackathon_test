package com.example.test

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.test.databinding.FragmentLoginBinding
import com.example.test.utils.APIUtil


class fragment_login : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        private val apiUtil = APIUtil()
//        findViewById<Button>(R.id.test_request_button).setOnClickListener {
//            val context = this
//            thread {
//                val response = apiUtil.getRequest("users")
//                context.runOnUiThread {
//                    Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//
//        findViewById<Button>(R.id.test_post_request_button).setOnClickListener {
//            val context = this
//            thread {
//                // TODO: use JSON parser classes?
//                val response = apiUtil.postRequest("signup",
//                    JSONObject()
//                        .put("username", "yehonatan")
//                        .put("password", "123456")
//                )
//                context.runOnUiThread {
//                    Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)


        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.navOptions.setOnClickListener { view:View -> view.findNavController().navigate(fragment_loginDirections.actionFragmentLoginToFragmentOptions()) }

        return binding.root

    }

}