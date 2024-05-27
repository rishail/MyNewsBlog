package com.example.mynewsblog.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynewsblog.R
import com.example.mynewsblog.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding= FragmentSplashBinding.inflate(layoutInflater, container, false)

        goToLogin()

        return binding.root
    }

    private fun goToLogin(){

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
        }
    }

}