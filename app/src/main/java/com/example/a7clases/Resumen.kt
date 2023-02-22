package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a7clases.databinding.ActivityResumenBinding

class Resumen : AppCompatActivity() {
    private lateinit var binding: ActivityResumenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val p1 = Personaje("", 0, "", "",0,0,0)

        //coger datos de la variable clase y raza
        val clase = intent.getStringExtra("clase")
        val raza = intent.getStringExtra("raza")

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
        binding.monedero.text = 0.toString()

        //si pulsa volver, vuelve a la pantalla principal
        binding.volver.setOnClickListener {
            val intent = Intent(this@Resumen, MainActivity::class.java)
            startActivity(intent)
        }

        //si pulsa comenzar, pasa a la pantalla de juego
        binding.comenzar.setOnClickListener {
            print("hola")
            val intent = Intent(this@Resumen, Juego::class.java)
            startActivity(intent)
        }

        //guardar valores en Personaje
        binding.comenzar.setOnClickListener {
            val fuerza = binding.fuerza.text.toString().toInt()
            val defensa = binding.defensa.text.toString().toInt()
            val vida = binding.vida.text.toString().toInt()
            val mochila = binding.mochila.text.toString().toInt()
            p1.setFuerza(fuerza)
            p1.setDefensa(defensa)
            p1.setVida(vida)
            p1.setPesoMochila(mochila)
            Toast.makeText(this, "Valores guardados", Toast.LENGTH_SHORT).show()
        }

        //comezar juego si se ha guardado el nombre
        binding.comenzar.setOnClickListener {
            p1.setNombre(binding.nombre.text.toString())
            if (p1.getNombre() == ""){
                Toast.makeText(this, "Debes guardar un nombre", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Nombre guardado", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Resumen, Juego::class.java)
                startActivity(intent)
            }
        }





    }
}