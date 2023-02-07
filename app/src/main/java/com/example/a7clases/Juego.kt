package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityJuegoBinding
class Juego : AppCompatActivity() {
    private lateinit var binding: ActivityJuegoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_juego)

        val array = arrayOf("Encontrar un Objeto", "Encontrar una Ciudad", "Encontrar un Mercader", "Encontrar un Enemigo")
        var resultado = ""

        //funcion cuando se pulsa el dado se genera un resutlado aleatorio
        binding.dado.setOnClickListener {
          resultado = array.random()
        }

        when(resultado){
            "Encontrar un Objeto" -> {
                val intent = Intent(this@Juego, Objeto::class.java)
                startActivity(intent)
            }
            "Encontrar una Ciudad" -> {
                val intent = Intent(this@Juego, Ciudad::class.java)
                startActivity(intent)
            }
            "Encontrar un Mercader" -> {
                val intent = Intent(this@Juego, Mercader::class.java)
                startActivity(intent)
            }
            "Encontrar un Enemigo" -> {
                val intent = Intent(this@Juego, Enemigo::class.java)
                startActivity(intent)
            }
        }

    }

}