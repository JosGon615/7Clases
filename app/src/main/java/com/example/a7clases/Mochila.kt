package com.example.a7clases

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMochilaBinding
import com.google.gson.Gson

class Mochila : AppCompatActivity() {
    private lateinit var binding: ActivityMochilaBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMochilaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        val persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        val mochila = pers.mochila

        binding.MochilaObj.text = pers.mochila.toString()

        binding.MochilaObj.text = "Objetos: ${pers.mochila} \n"




    }
}