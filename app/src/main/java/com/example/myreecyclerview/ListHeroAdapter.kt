package com.example.myreecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myreecyclerview.databinding.ActivityDetailBinding
import com.example.myreecyclerview.databinding.ItemRowHeroBinding


class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)
    class ViewDetail(var binding: ActivityDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ViewDetail, index: Int) {
//        val (name, description, photo) = listHero[index]
//        holder.binding.imageView.setImageResource(photo)
//        holder.binding.tvJudulAnime.text = name
//        holder.binding.tvDescription.text = description

        val (name, description, photo, author, episode) = listHero[index]
        holder.binding.tvJudulAnime.text = name
        holder.binding.imageView.setImageResource(photo)
        holder.binding.tvAuthor.text = author
        holder.binding.tvEpisode.text = episode
        holder.binding.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("DATA", listHero[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

}