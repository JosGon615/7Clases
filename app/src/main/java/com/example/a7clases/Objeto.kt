package com.example.a7clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7clases.databinding.ActivityObjetoBinding
import com.example.a7clases.databinding.ActivityResumenBinding

class Objeto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var aleatorio= (1..50).random()

        when(aleatorio){
            in 1..10-> binding.objeto.setBackgroundResource(R.drawable.senzu)
            in 11..20-> binding.objeto.setBackgroundResource(R.drawable.radar)
            in 30..33 -> binding.objeto.setBackgroundResource(R.drawable.dbuno)
            in 34..37-> binding.objeto.setBackgroundResource(R.drawable.dbdos)
            in 38..41-> binding.objeto.setBackgroundResource(R.drawable.dbtres_)
            in 42..45-> binding.objeto.setBackgroundResource(R.drawable.dbcuatro_)
            in 46..47-> binding.objeto.setBackgroundResource(R.drawable.dbcinco)
            in 48..49-> binding.objeto.setBackgroundResource(R.drawable.dbseis)
            50-> binding.objeto.setBackgroundResource(R.drawable.dbsiete)


        }

    }
}