package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var clase = ""

        //cambiar imagen al pulsar el boton
        binding.guerrero.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.guerrero)
            clase = "guerrero"
        }
        binding.mago.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.mago)
            clase = "mago"
        }
        binding.arquero.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.arquero)
            clase = "arquero"
        }
        binding.clerigo.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.clerigo)
            clase = "clerigo"
        }


        binding.aceptar.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("clase", clase)
            startActivity(intent)
        }

    }

}