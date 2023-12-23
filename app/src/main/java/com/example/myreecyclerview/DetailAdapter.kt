package com.example.myreecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myreecyclerview.databinding.ActivityDetailBinding
import com.example.myreecyclerview.databinding.ItemRowHeroBinding

abstract class DetailAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<DetailAdapter.ListViewHolder>() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
//
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    class ListViewHolder(var binding: ActivityDetailBinding) : RecyclerView.ViewHolder(binding.root)

//    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
//        val binding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ListViewHolder(binding)
//    }

//    override fun onBindViewHolder(holder: ListHeroAdapter.ViewDetail, position: Int) {
//        val (name, description, photo, author, episode) = listHero[position]
//        holder.binding.tvJudulAnime?.text = name
//        holder.binding.imageView.setImageResource(photo)
//        holder.binding.tvAuthor?.text = author
//        holder.binding.tvEpisode?.text = episode
//        holder.binding.tvDescription?.text = description
//    }

    override fun getItemCount(): Int = listHero.size

}