package com.example.submissionandroidbeginnner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.submissionandroidbeginnner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<Berita> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvNews.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecylerList()
    }

    private fun showRecylerList() {
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        val listBeritaManager = ListBeritaAdapter(list)
        binding.rvNews.adapter = listBeritaManager

    }

    private fun getListHeroes(): Collection<Berita> {
        val dataTitle = resources.getStringArray(R.array.list_news_title)
        val dataWriter = resources.getStringArray(R.array.list_news_writer)
        val dataDate = resources.getStringArray(R.array.list_news_date)
        val dataDescription = resources.getStringArray(R.array.list_news_description)
        val dataImage = resources.obtainTypedArray(R.array.list_news_image)

        val listNews = ArrayList<Berita>()
        for (i in dataTitle.indices){
            val news = Berita(dataTitle[i], dataWriter[i], dataDate[i], dataDescription[i], dataImage.getResourceId(i, -1))
            listNews.add(news)
        }
        return listNews
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.user_profile -> {
                val intent = Intent(this@MainActivity, UserActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}