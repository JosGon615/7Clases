package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityJuegoBinding
class Juego : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var resultado = 0

        //funcion cuando se pulsa el dado se genera un resutlado aleatorio
        binding.dado.setOnClickListener {
            resultado = (0..3).random()
           when(resultado){
            0 -> {
                val intent = Intent(this@Juego, Objeto::class.java)
                startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@Juego, Ciudad::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@Juego, Mercader::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@Juego, Enemigo::class.java)
                startActivity(intent)
            }
        }
        }
    }
}
