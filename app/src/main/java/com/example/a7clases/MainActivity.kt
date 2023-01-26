package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.a7clases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mostrar imagen al pulsar el boton
        binding.clerigo.setOnClickListener {
            if(binding.clerigoI.visibility == View.INVISIBLE){
                binding.clerigoI.visibility = View.VISIBLE
            }else{
                binding.clerigoI.visibility = View.INVISIBLE
            }
        }

        binding.mago.setOnClickListener {
            if(binding.magoI.visibility == View.INVISIBLE){
                binding.magoI.visibility = View.VISIBLE
            }else{
                binding.magoI.visibility = View.INVISIBLE
            }
        }

        binding.guerrero.setOnClickListener {
            if(binding.guerreroI.visibility == View.INVISIBLE){
                binding.guerreroI.visibility = View.VISIBLE
            }else{
                binding.guerreroI.visibility = View.INVISIBLE
            }
        }

        binding.arquero.setOnClickListener {
            if(binding.arqueroI.visibility == View.INVISIBLE){
                binding.arqueroI.visibility = View.VISIBLE
            }else{
                binding.arqueroI.visibility = View.INVISIBLE
            }
        }

    }

}