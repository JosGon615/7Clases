package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityJuegoBinding
import com.example.a7clases.databinding.ActivityResumenBinding
class Juego : AppCompatActivity() {
    private lateinit var binding: ActivityJuegoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_juego)


    }


}