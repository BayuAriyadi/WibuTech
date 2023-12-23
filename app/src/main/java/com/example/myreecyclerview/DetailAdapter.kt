package com.example.myreecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myreecyclerview.databinding.ActivityDetailBinding

abstract class DetailAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<DetailAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }


    class ListViewHolder(var binding: ActivityDetailBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onBindViewHolder(holder: ListViewHolder, index: Int) {
        val (judul, desc, photo, author, eps ) = listHero[index]
        holder.binding.imageView.setImageResource(photo)
        holder.binding.tvJudulAnime.text = judul
        holder.binding.tvAuthor.text = author
        holder.binding.tvEpisode.text = eps
        holder.binding.tvDescription.text = desc
    }
}