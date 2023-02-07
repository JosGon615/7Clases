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
         var clase = intent.getStringExtra("clase")

        //cambiar imagen al pulsar el boton
        binding.androide.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.androide)
            raza = "androide"
        }
        binding.namekiano.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.namekiano)
            raza = "namekiano"
        }
        binding.terricola.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.terricola)
            raza = "terricola"
        }
        binding.saiyan.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.saiyan)
            raza = "saiyan"
        }


        binding.aceptar.setOnClickListener {
            val intent = Intent(this@MainActivity2, Resumen::class.java)
            intent.putExtra("raza", raza)
            intent.putExtra("clase", clase)
            startActivity(intent)
        }



    }


}