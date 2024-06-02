package com.example.mynewsblog.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewsblog.ui.adapters.NewsListAdapter
import com.example.mynewsblog.data.NewsRepository
import com.example.mynewsblog.data.model.NewsArticleModel
import com.example.mynewsblog.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null

    private var newsList = ArrayList<NewsArticleModel>()

    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentNewsBinding.inflate(inflater, container, false)

        adapter = NewsListAdapter(newsList,requireContext())

        fetchNewsArticles()

        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun fetchNewsArticles() {

        lifecycleScope.launch {
            try {
                val response = newsRepository.fetchNews()
                newsList.clear()
                newsList.addAll(response.articles)
                adapter?.notifyDataSetChanged()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Failed to fetch news: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}