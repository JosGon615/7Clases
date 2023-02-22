package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityObjetoBinding
import com.example.a7clases.databinding.ActivityResumenBinding
import com.google.gson.Gson

class Objeto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        var gson = Gson()
        var persString = compartir.getString("Personaje", "")
        var pers = gson.fromJson(persString, Personaje::class.java)



        var aleatorio= (1..50).random()
        var objeto = ObjetoC()

        when(aleatorio){
            in 1..10-> {binding.objeto.setBackgroundResource(R.drawable.senzu)
                objeto = ObjetoC("Senzu", 15,100,200)
            }

            in 11..30-> binding.objeto.setBackgroundResource(R.drawable.radar)

            in 30..33 -> binding.objeto.setBackgroundResource(R.drawable.dbuno)
            in 34..37-> binding.objeto.setBackgroundResource(R.drawable.dbdos)
            in 38..41-> binding.objeto.setBackgroundResource(R.drawable.dbtres_)
            in 42..45-> binding.objeto.setBackgroundResource(R.drawable.dbcuatro_)
            in 46..47-> binding.objeto.setBackgroundResource(R.drawable.dbcinco)
            in 48..49-> binding.objeto.setBackgroundResource(R.drawable.dbseis)
            50-> binding.objeto.setBackgroundResource(R.drawable.dbsiete)
        }

        binding.recoger.setOnClickListener {
            pers.mochila.add(objeto)
            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()

            val intent = Intent(this@Objeto, Juego::class.java)
            startActivity(intent)

        }

    }
}