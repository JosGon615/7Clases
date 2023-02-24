package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityCiudadBinding

class Ciudad : AppCompatActivity() {

    private lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continuarC.setOnClickListener {
            val intent = Intent(this@Ciudad, Dado::class.java)
            startActivity(intent)
        }
    }
}