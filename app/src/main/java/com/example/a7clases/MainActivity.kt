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
        binding.kame.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.kamep)
            clase = "kame"
        }
        binding.kaio.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.kaiop)
            clase = "kaio"
        }
        binding.go.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.gop)
            clase = "go"
        }
        binding.wish.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.wishp)
            clase = "wish"
        }


        binding.aceptar.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("clase", clase)
            startActivity(intent)
        }

    }

}