package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityCombateBinding

import com.google.gson.Gson

class Combate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCombateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        val persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        val objeto = ObjetoC("Senzu", 5,10,20)

        binding.objetoC.setOnClickListener() {
            if(pers.mochila.contains(objeto)){
                pers.setVida(pers.getVida() + 20)
                pers.mochila.remove(objeto)
            }
        }



    }
}