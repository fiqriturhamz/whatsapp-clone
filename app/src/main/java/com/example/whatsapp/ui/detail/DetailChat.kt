package com.example.whatsapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import com.example.whatsapp.R

class DetailChat : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setContentView(R.layout.activity_detail_chat)
     supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(toolbar)


    }


}