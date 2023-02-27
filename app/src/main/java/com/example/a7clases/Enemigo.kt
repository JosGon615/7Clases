package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityEnemigoBinding
import com.google.gson.Gson

class Enemigo : AppCompatActivity() {
    private lateinit var binding: ActivityEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        binding.huir.setOnClickListener {
            val intent = Intent(this@Enemigo, Dado::class.java)
            startActivity(intent)
        }

        binding.luchar.setOnClickListener {
            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()
            val intent = Intent(this@Enemigo, Combate::class.java)
            startActivity(intent)
        }
    }
}