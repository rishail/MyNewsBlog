package com.example.mynewsblog.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mynewsblog.data.api.ApiService
import com.example.mynewsblog.model.LoginRequestModel
import com.example.mynewsblog.R
import com.example.mynewsblog.databinding.FragmentSignInBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    private val apiService: ApiService by inject(named("LoginApiService"))

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.text.trim().toString()
            val password = binding.etPwd.text.trim().toString()

            loginAuthentication(email, password)

        }
        return binding.root
    }

    private fun loginAuthentication(email: String, password: String) {
        val loginRequest = LoginRequestModel(email, password)

        lifecycleScope.launch {
            try {
                val response = apiService.login(loginRequest)
                val token = response.token
                Toast.makeText(requireContext(), "Login Successful $token", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signInFragment_to_newsFragment)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Login failed. Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
    }
