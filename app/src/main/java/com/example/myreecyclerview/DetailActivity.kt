package com.example.myreecyclerview

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myreecyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    companion object {
        const val ANIME = "anime"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(ANIME, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(ANIME)
        }

        if (dataHero != null) {
            binding.imageView.setImageResource(dataHero.photo)
            binding.tvJudulAnime.text = dataHero.name
            binding.tvAuthor.text = dataHero.author
            binding.tvEpisode.text = dataHero.episode
            binding.tvDescription.text = dataHero.description
        }

        val url = "https://github.com/BayuAriyadi"

        binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)



            intent.type = "text/plain"
            intent.putExtra("Share This anime", url)

            val chooser = Intent.createChooser(intent, "Share Using...")
            startActivity(chooser)
        }
    }


}