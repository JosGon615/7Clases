package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityObjetoBinding
import com.example.a7clases.databinding.ActivityResumenBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_objeto)


    }
}