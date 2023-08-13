package com.example.submissionandroidbeginnner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatImageButton

class UserActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val actionBar = supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(R.layout.action_bar_detail_activity)

        val customAction = actionBar?.customView
        val btnBack: AppCompatImageButton = customAction!!.findViewById(R.id.btnBack)

        btnBack.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnBack -> {
                val intent = Intent(this@UserActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}