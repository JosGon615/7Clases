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

        when (pers.contador){
            0 -> binding.contador.setImageResource(R.drawable.cero)
            1 -> binding.contador.setImageResource(R.drawable.uno)
            2 -> binding.contador.setImageResource(R.drawable.dos)
            3 -> binding.contador.setImageResource(R.drawable.tres)
            4 -> binding.contador.setImageResource(R.drawable.cuatro)
            5 -> binding.contador.setImageResource(R.drawable.cinco)
        }

        //cuando se pulsa el dado se genera un resutlado aleatorio
        binding.dado.setOnClickListener {
            resultado = (0..4).random()
            when (resultado) {
                in 0..2 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Objeto::class.java)
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
                4 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Mercader::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()
                    val intent = Intent(this@Dado, Ciudad::class.java)
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
