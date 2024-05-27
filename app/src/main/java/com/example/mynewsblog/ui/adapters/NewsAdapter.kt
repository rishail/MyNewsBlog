package com.example.musicplayer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsblog.data.model.NewsArticleModel
import com.example.mynewsblog.databinding.NewsListAdapterBinding


class NewsListAdapter(
    private var newsList: ArrayList<NewsArticleModel>,
//    private val callback: SongsListFragment,

    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ViewHolder(val binding: NewsListAdapterBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = NewsListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,@SuppressLint("RecyclerView") position: Int) {
        holder as ViewHolder

        holder.binding.newsTitle.text=newsList[position].title
        holder.binding.newsDescription.text=newsList[position].description

    }

    fun updateNewsList(newNewsList: ArrayList<NewsArticleModel>) {
        newsList = newNewsList
        notifyDataSetChanged()

    }




}




