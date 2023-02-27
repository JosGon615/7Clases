package com.example.a7clases

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val pers = Personaje()

        //cambiar imagen al pulsar el boton
        binding.kame.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.kame)
            pers.setClase("kame")

        }
        binding.kaio.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.kaio)
            pers.setClase("kaio")
        }
        binding.go.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.go)
            pers.setClase("go")
        }
        binding.wish.setOnClickListener {
            binding.imageView.setBackgroundResource(R.drawable.wish)
            pers.setClase("wish")
        }

        binding.aceptar.setOnClickListener {
            val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
            val editor = compartir.edit()
            val gson = Gson()
            val persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

    }

}