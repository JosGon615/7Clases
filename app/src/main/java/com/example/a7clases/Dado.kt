package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityDadoBinding
import com.google.gson.Gson

class Dado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        var resultado = 0

        //funcion cuando se pulsa el dado se genera un resutlado aleatorio
        binding.dado.setOnClickListener {
            resultado = (0..3).random()
            when (resultado) {
                0 -> {
                    val intent = Intent(this@Dado, Objeto::class.java)
                    startActivity(intent)
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                }
                1 -> {
                    val intent = Intent(this@Dado, Ciudad::class.java)
                    startActivity(intent)
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                }
                2 -> {
                    val intent = Intent(this@Dado, Mercader::class.java)
                    startActivity(intent)
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                }
                3 -> {
                    val intent = Intent(this@Dado, Enemigo::class.java)
                    startActivity(intent)
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                }

            }


        }
        binding.imageButton3.setOnClickListener {
            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()
            val intent = Intent(this@Dado, Mochila::class.java)
            startActivity(intent)
        }
    }
}
