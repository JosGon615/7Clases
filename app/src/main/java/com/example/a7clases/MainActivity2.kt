package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMain2Binding
import com.google.gson.Gson

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)



        //cambiar imagen al pulsar el boton
        binding.androide.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.androide)
            pers.setRaza("androide")
        }
        binding.namekiano.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.namekiano)
            pers.setRaza("namekiano")
        }
        binding.terricola.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.terricola)
            pers.setRaza("terricola")
        }
        binding.saiyan.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.saiyan)
            pers.setRaza("saiyan")
        }


        binding.aceptar.setOnClickListener {
            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()

            val intent = Intent(this@MainActivity2, Resumen::class.java)
            startActivity(intent)
        }



    }


}