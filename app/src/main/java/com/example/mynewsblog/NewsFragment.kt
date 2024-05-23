package com.example.mynewsblog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.NewsListAdapter
import com.example.mynewsblog.databinding.FragmentNewsBinding
import com.example.mynewsblog.databinding.NewsListAdapterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null
    private lateinit var apiService: ApiService


    private var newsList = ArrayList<NewsArticleModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentNewsBinding.inflate(inflater, container, false)

        adapter= NewsListAdapter(newsList,requireContext())

        fetchNews()

        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun fetchNews() {
        val query = "apple"
        val from = "2024-05-20"
        val to = "2024-05-20"
        val sortBy = "popularity"
        val apiKey = "4f5e4f2de7c544228066f19efac3ad9e"


        val retrofitClient = RetrofitClient()
        apiService = retrofitClient.newsApiService

        retrofitClient.newsApiService.getNews(query, from, to, sortBy, apiKey)?.enqueue(object : Callback<NewsResponseModel?> {

            override fun onResponse(call: Call<NewsResponseModel?>,response: Response<NewsResponseModel?>) {

                if (response.isSuccessful && response.body() != null) {
                    val articles = response.body()!!.articles

                    newsList.clear()
                    newsList.addAll(articles)
                    adapter?.updateNewsList(newsList)

                }

                else {
                    Toast.makeText(requireContext(), "Failed to retrieve news", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponseModel?>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()

            }
        })
    }

}