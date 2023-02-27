package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityCombateBinding
import com.example.a7clases.databinding.ActivityDeathBinding
import com.example.a7clases.databinding.ActivityResumenBinding

class Death : AppCompatActivity() {
    private lateinit var binding: ActivityDeathBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reiniciar.setOnClickListener {
            val intent = Intent(this@Death, MainActivity::class.java)
            startActivity(intent)
        }
    }


}