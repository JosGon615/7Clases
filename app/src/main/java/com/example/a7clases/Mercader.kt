package com.example.a7clases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

        var objeto = ObjetoC("Scouter", 5,10,20)
        var cantidad = 0

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

            binding.mas.visibility = View.VISIBLE
            binding.menos.visibility = View.VISIBLE
            binding.cantidad.visibility = View.VISIBLE
        }

        //al pulsar el boton de cancelar, se ocultan los botones de cancelar, comprar y vender y aparece el de comerciar y continuar
        binding.cancelar.setOnClickListener(){
            binding.mercader.setImageResource(R.drawable.baba)
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
        binding.mas.setOnClickListener(){
            cantidad = (binding.cantidad.text.toString().toInt() + 1)
            binding.cantidad.text = cantidad.toString()
        }
        binding.menos.setOnClickListener(){
            if(binding.cantidad.text.toString().toInt() > 0){
                cantidad= (binding.cantidad.text.toString().toInt() - 1)
                binding.cantidad.text = cantidad.toString()
            }
        }

        //boton comprar
        binding.comprar.setOnClickListener(){


            if(cantidad * objeto.peso <= pers.getPesoMochila()){
                pers.mochila.add(objeto)
                pers.setPesoMochila(pers.getPesoMochila() - objeto.peso*cantidad)
                Toast.makeText(this, "Has comprado ${cantidad} ${objeto.nombre}", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "No tienes espacio en la mochila", Toast.LENGTH_SHORT).show()
            }
        }

        //boton vender
        binding.vender.setOnClickListener(){
            binding.mercader.setImageResource(R.drawable.mochila)

            binding.confirmar.set
            if(pers.mochila.contains(objeto)){
                pers.mochila.remove(objeto)
                pers.setPesoMochila(pers.getPesoMochila() + objeto.peso*cantidad)
                Toast.makeText(this, "Has vendido ${cantidad} ${objeto.nombre}", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "No tienes ${objeto.nombre} en la mochila", Toast.LENGTH_SHORT).show()
            }
        }


    }

}