package com.example.mynewsblog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mynewsblog.databinding.FragmentSignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var apiService: ApiService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        val retrofitClient = RetrofitClient()
        apiService = retrofitClient.loginApiService

        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.text.trim().toString()
            val password = binding.etPwd.text.trim().toString()
            loginAuthentication(email, password)
        }
        return binding.root
    }

    private fun loginAuthentication(email: String, password: String) {
        val loginRequest = LoginRequestModel(email, password)

        val call = apiService.login(loginRequest)
        call?.enqueue(object : Callback<LoginResponseModel?> {
            override fun onResponse(call: Call<LoginResponseModel?>, response: Response<LoginResponseModel?>) {
                if (response.isSuccessful && response.body() != null) {
                    val token = response.body()?.token
                    Log.d("1234", "Login Successful $token")
                    findNavController().navigate(R.id.action_signInFragment_to_newsFragment)
                } else {
                    Toast.makeText(requireContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponseModel?>, t: Throwable) {
                Toast.makeText(requireContext(), "Login failed. Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
