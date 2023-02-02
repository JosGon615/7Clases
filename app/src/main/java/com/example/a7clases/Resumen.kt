package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMain2Binding
import com.example.a7clases.databinding.ActivityResumenBinding

class Resumen : AppCompatActivity() {
    private lateinit var binding: ActivityResumenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var clase = intent.getStringExtra("clase")
        var raza = intent.getStringExtra("raza")


        when (clase){
            "guerrero" -> binding.clase.setImageResource(R.drawable.guerrero)
            "mago" -> binding.clase.setImageResource(R.drawable.mago)
            "arquero" -> binding.clase.setImageResource(R.drawable.arquero)
            "clerigo" -> binding.clase.setImageResource(R.drawable.clerigo)
        }

        when (raza){
            "enano" -> binding.raza.setBackgroundResource(R.drawable.enano)
            "elfo" -> binding.raza.setBackgroundResource(R.drawable.elfo)
            "demonio" -> binding.raza.setBackgroundResource(R.drawable.demonio)
            "saiyan" -> binding.raza.setBackgroundResource(R.drawable.saiyan)
        }




    }
}