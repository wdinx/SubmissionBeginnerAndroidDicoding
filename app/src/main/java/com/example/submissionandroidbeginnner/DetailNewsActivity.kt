package com.example.submissionandroidbeginnner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailNewsActivity : AppCompatActivity() {
    companion object{
        const val KEY_EXTRA = "key_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
    }
}