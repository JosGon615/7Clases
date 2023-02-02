package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var raza = ""

        //cambiar imagen al pulsar el boton
        binding.enano.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.enano)
            raza = "enano"
        }
        binding.elfo.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.elfo)
            raza = "elfo"
        }
        binding.demonio.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.demonio)
            raza = "demonio"
        }
        binding.saiyan.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.saiyan)
            raza = "saiyan"
        }


        binding.aceptar.setOnClickListener {
            val intent = Intent(this@MainActivity2, Resumen::class.java)
            startActivity(intent)
        }

    }


}