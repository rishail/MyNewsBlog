package com.example.mynewsblog.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewsblog.BuildConfig
import com.example.mynewsblog.ui.NewsListAdapter
import com.example.mynewsblog.data.api.ApiService
import com.example.mynewsblog.model.NewsArticleModel
import com.example.mynewsblog.databinding.FragmentNewsBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null

    private var newsList = ArrayList<NewsArticleModel>()

    private val apiService: ApiService by inject(named("NewsApiService"))

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentNewsBinding.inflate(inflater, container, false)

        adapter = NewsListAdapter(newsList)

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
        val apiKey = BuildConfig.API_KEY

        lifecycleScope.launch {
            try {
                val response = apiService.getNews(query, from, to, sortBy, apiKey)
                val articles = response.articles
                newsList.clear()
                newsList.addAll(articles)
                adapter?.notifyDataSetChanged()
                Log.d("1234", articles.toString())
            }
            catch (e: Exception) {
                Toast.makeText(requireContext(),"Failed to retrieve news. Error: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
