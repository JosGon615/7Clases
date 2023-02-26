package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a7clases.databinding.ActivityResumenBinding
import com.google.gson.Gson

class Resumen : AppCompatActivity() {
    private lateinit var binding: ActivityResumenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)


        //coger datos de la variable clase y raza
        val clase = pers.getClase()
        val raza = pers.getRaza()

        //seleccionar imagenes segun la clase y raza
        when (clase){
            "kame" -> binding.claseI.setBackgroundResource(R.drawable.kamep)
            "kaio" -> binding.claseI.setBackgroundResource(R.drawable.kaiop)
            "go" -> binding.claseI.setBackgroundResource(R.drawable.gop)
            "wish" -> binding.claseI.setBackgroundResource(R.drawable.wishp)
        }

        when (raza){
            "androide" -> binding.razaI.setBackgroundResource(R.drawable.androidep)
            "namekiano" -> binding.razaI.setBackgroundResource(R.drawable.namekianop)
            "terricola" -> binding.razaI.setBackgroundResource(R.drawable.terricolap)
            "saiyan" -> binding.razaI.setBackgroundResource(R.drawable.saiyanp)
        }

        //mostrar valores aleatorios
        binding.fuerza.text = (10..15).random().toString()
        binding.defensa.text = (1..15).random().toString()
        binding.vida.text = 200.toString()
        binding.mochila.text = 100.toString()
        binding.monedero.text = 9999.toString()

        //si pulsa volver, vuelve a la pantalla principal
        binding.volver.setOnClickListener {
            val intent = Intent(this@Resumen, MainActivity::class.java)
            startActivity(intent)
        }

        //si pulsa comenzar, pasa a la pantalla de juego
        binding.comenzar.setOnClickListener {
            print("hola")
            val intent = Intent(this@Resumen, Dado::class.java)
            startActivity(intent)
        }


        //comezar juego si se ha guardado el nombre
        binding.comenzar.setOnClickListener {
            val fuerza = binding.fuerza.text.toString().toInt()
            val defensa = binding.defensa.text.toString().toInt()
            val vida = binding.vida.text.toString().toInt()
            val nombre = binding.nombre.text.toString()
            val mochila = binding.mochila.text.toString().toInt()
            val dinero = binding.monedero.text.toString().toInt()
            pers.setFuerza(fuerza)
            pers.setDefensa(defensa)
            pers.setVida(vida)
            pers.setNombre(nombre)
            pers.setPesoMochila(mochila)
            pers.setDinero(dinero)

            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()

            if (pers.getNombre() == ""){
                Toast.makeText(this, "Debes guardar un nombre", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Valores guardados", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Resumen, Dado::class.java)
                startActivity(intent)
            }
        }





    }
}