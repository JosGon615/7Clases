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
            resultado = 0
            when (resultado) {
                0 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Objeto::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Ciudad::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Mercader::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Enemigo::class.java)
                    startActivity(intent)
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
