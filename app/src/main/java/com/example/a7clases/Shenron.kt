package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityShenronBinding

class Shenron : AppCompatActivity() {
    private lateinit var binding: ActivityShenronBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShenronBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}