package com.example.mynewsblog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.NewsListAdapter
import com.example.mynewsblog.databinding.FragmentNewsBinding
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null

    private var newsList = ArrayList<NewsArticleModel>()

    @Inject
    lateinit var newsRepository: NewsRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNewsBinding.inflate(inflater, container, false)

        adapter = NewsListAdapter(newsList, requireContext())

        fetchNewsArticles()

        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun fetchNewsArticles() {
        val apiKey = "YOUR_API_KEY"
        val query = "technology"
        val from = "2022-01-01"
        val to = "2022-01-31"
        val sortBy = "publishedAt"

        lifecycleScope.launch {
            try {
                val response = newsRepository.fetchNews(apiKey, query, from, to, sortBy)
                binding.rvNews.adapter = NewsListAdapter(newsList, requireContext())
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Failed to fetch news: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}