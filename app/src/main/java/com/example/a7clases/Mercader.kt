package com.example.a7clases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.a7clases.databinding.ActivityMercaderBinding
import com.google.gson.Gson

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        val persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        binding.continuarM.setOnClickListener(){
            val intent = Intent(this@Mercader, Dado::class.java)
            startActivity(intent)
        }

        //al pulsar el boton de comerciar, se ocultan los botones de comerciar y continuar y aparece el de cancelar, comprar y vender
        binding.comerciar.setOnClickListener(){
            binding.comerciar.visibility = View.GONE
            binding.continuarM.visibility = View.GONE
            binding.cancelar.visibility = View.VISIBLE
            binding.comprar.visibility = View.VISIBLE
            binding.vender.visibility = View.VISIBLE
        }

        //al pulsar el boton de cancelar, se ocultan los botones de cancelar, comprar y vender y aparece el de comerciar y continuar
        binding.cancelar.setOnClickListener(){
            binding.comerciar.visibility = View.VISIBLE
            binding.continuarM.visibility = View.VISIBLE
            binding.cancelar.visibility = View.GONE
            binding.comprar.visibility = View.GONE
            binding.vender.visibility = View.GONE
            binding.mas.visibility = View.GONE
            binding.menos.visibility = View.GONE
            binding.cantidad.visibility = View.GONE
        }

        //al pulsar el boton comprar, se ocultan los botones de cancelar y vender
        binding.comprar.setOnClickListener(){
            binding.mercader.setImageResource(R.drawable.scouter)

            binding.mas.visibility = View.VISIBLE
            binding.menos.visibility = View.VISIBLE
            binding.cantidad.visibility = View.VISIBLE
        }
        binding.mas.setOnClickListener(){
            binding.cantidad.text = (binding.cantidad.text.toString().toInt() + 1).toString()
        }
        binding.menos.setOnClickListener(){
            if(binding.cantidad.text.toString().toInt() > 0){
                binding.cantidad.text = (binding.cantidad.text.toString().toInt() - 1).toString()
            }
        }
    }
}