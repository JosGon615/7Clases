package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a7clases.databinding.ActivityObjetoBinding
import com.google.gson.Gson

class Objeto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        val radar = ObjetoC("Radar", 5, 10, 20)
        val senzu = ObjetoC("Senzu", 5, 10, 20)
        val db1 = ObjetoC("Dragon Ball 1", 10, 100, 20)
        val db2 = ObjetoC("Dragon Ball 2", 10, 100, 20)
        val db3 = ObjetoC("Dragon Ball 3", 10, 100, 20)
        val db4 = ObjetoC("Dragon Ball 4", 10, 100, 20)
        val db5 = ObjetoC("Dragon Ball 5", 10, 100, 20)
        val db6 = ObjetoC("Dragon Ball 6", 10, 100, 20)
        val db7 = ObjetoC("Dragon Ball 7", 10, 100, 20)

        var flag = false
        var aleatorio = 0
        var objeto = ObjetoC()

        //comprueba si tienes radar
        pers.mochila.forEach() {
            if (it.nombre == "Radar") {
                flag = true
            }
        }

        //si no tienes radar no aparecen las dragon balls
        if (!flag) {
            aleatorio = (1..10).random()
        }

        //si tienes radar aparecen las dragon balls y el radar deja de aparecer
        else {
            aleatorio = (7..50).random()
        }

        //selecciona un objeto aleatorio
        when (aleatorio) {
            in 1..6 -> {
                binding.objeto.setBackgroundResource(R.drawable.radar)
                objeto = radar
            }
            in 7..10 -> {
                binding.objeto.setBackgroundResource(R.drawable.senzu)
                objeto = senzu
            }
            in 11..16-> {
                binding.objeto.setBackgroundResource(R.drawable.dbuno)
                objeto = db1
            }
            in 17..22 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbdos)
                objeto = db2
            }
            in 23..28 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbtres_)
                objeto = db3
            }
            in 29..34 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbcuatro_)
                objeto = db4
            }
            in 35..40 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbcinco)
                objeto = db5
            }
            in 41..46 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbseis)
                objeto = db6
            }
            in 47..50 -> {
                binding.objeto.setBackgroundResource(R.drawable.dbsiete)
                objeto = db7
            }
        }

        //solo se puede recoger una bola de dragon de cada
        binding.recoger.setOnClickListener {
            flag = false
            pers.mochila.forEach {
                if (it.nombre == objeto.nombre) {
                    flag = true
                }

            }
            if (pers.getPesoMochila() >= objeto.peso) {
                if (!flag) {
                    pers.mochila.add(objeto)
                    pers.setPesoMochila(pers.getPesoMochila() - objeto.peso)
                    Toast.makeText(this, "Has recogido ${objeto.nombre}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ya tienes este objeto", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No tienes espacio en la mochila", Toast.LENGTH_SHORT).show()
            }
        }

        //si recoges las 7 bolas de dragon te lleva a la pantalla de shenron sino te lleva al dado
        binding.continuar.setOnClickListener {

            val eliminardb1 = pers.mochila.find { it.nombre == "Dragon Ball 1" }
            val eliminardb2 = pers.mochila.find { it.nombre == "Dragon Ball 2" }
            val eliminardb3 = pers.mochila.find { it.nombre == "Dragon Ball 3" }
            val eliminardb4 = pers.mochila.find { it.nombre == "Dragon Ball 4" }
            val eliminardb5 = pers.mochila.find { it.nombre == "Dragon Ball 5" }
            val eliminardb6 = pers.mochila.find { it.nombre == "Dragon Ball 6" }
            val eliminardb7 = pers.mochila.find { it.nombre == "Dragon Ball 7" }

            pers.contadorDragonBall = 0
            flag = false

            pers.mochila.forEach() {
                if(it.nombre == "Dragon Ball 1") {
                    pers.contadorDragonBall++
                }
                if(it.nombre == "Dragon Ball 2") {
                    pers.contadorDragonBall++
                }
                if(it.nombre == "Dragon Ball 3") {
                    pers.contadorDragonBall++
                }
                if(it.nombre == "Dragon Ball 4") {
                    pers.contadorDragonBall++
                }
                if(it.nombre == "Dragon Ball 5") {
                    pers.contadorDragonBall++
                }
                if(it.nombre == "Dragon Ball 6") {
                    pers.contadorDragonBall++
                }
                if (it.nombre == "Dragon Ball 7") {
                    pers.contadorDragonBall++
                }
            }
            if (pers.contadorDragonBall == 7) {
                flag = true
            }

            if (flag) {
                val editor = compartir.edit()
                persString = gson.toJson(pers)
                editor.putString("Personaje", persString)
                editor.apply()

                pers.mochila.remove(eliminardb1)
                pers.mochila.remove(eliminardb2)
                pers.mochila.remove(eliminardb3)
                pers.mochila.remove(eliminardb4)
                pers.mochila.remove(eliminardb5)
                pers.mochila.remove(eliminardb6)
                pers.mochila.remove(eliminardb7)

                val intent = Intent(this@Objeto, Shenron::class.java)
                startActivity(intent)
            }
            else {
                val editor = compartir.edit()
                persString = gson.toJson(pers)
                editor.putString("Personaje", persString)
                editor.apply()

                val intent = Intent(this@Objeto, Dado::class.java)
                startActivity(intent)
            }
        }

    }
}
