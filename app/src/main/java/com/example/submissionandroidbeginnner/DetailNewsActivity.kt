package com.example.submissionandroidbeginnner

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import com.example.submissionandroidbeginnner.databinding.ActivityDetailNewsBinding
import java.security.Key

class DetailNewsActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val KEY_EXTRA = "key_extra"
    }

    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.setDisplayOptions(androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(R.layout.action_bar_detail_activity)

        val customAction = actionBar.customView
        val btnBack : AppCompatImageButton  = customAction.findViewById(R.id.btnBack)

        btnBack.setOnClickListener(this)

        val dataBerita = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_EXTRA, Berita::class.java)
        } else {
            intent.getParcelableExtra(KEY_EXTRA)
        }

        binding.tvDetailNewsTitle.text = dataBerita!!.title
        binding.tvDetailNewsWriter.text = dataBerita.writer
        binding.tvDetailNewsDate.text = dataBerita.date
        binding.tvDetailNewsDescription.text = dataBerita.description
        binding.imgDetailNews.setImageResource(dataBerita.image)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnBack -> {
                val intent = Intent(this@DetailNewsActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}