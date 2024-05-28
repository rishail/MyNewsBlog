package com.example.musicplayer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsblog.NewsArticleModel
import com.example.mynewsblog.databinding.NewsListAdapterBinding


class NewsListAdapter(
    private var newsListAdapter: ArrayList<NewsArticleModel>,

    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ViewHolder(val binding: NewsListAdapterBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = NewsListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return newsListAdapter.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,@SuppressLint("RecyclerView") position: Int) {
        holder as ViewHolder







    }




}