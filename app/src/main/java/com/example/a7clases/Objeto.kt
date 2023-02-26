package com.example.a7clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a7clases.databinding.ActivityObjetoBinding
import com.google.gson.Gson

class Objeto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        val db1 = ObjetoC("Dragon Ball 1", 10,100,20)
        val db2 = ObjetoC("Dragon Ball 2", 10,100,20)
        val db3 = ObjetoC("Dragon Ball 3", 10,100,20)
        val db4 = ObjetoC("Dragon Ball 4", 10,100,20)
        val db5 = ObjetoC("Dragon Ball 5", 10,100,20)
        val db6 = ObjetoC("Dragon Ball 6", 10,100,20)
        val db7 = ObjetoC("Dragon Ball 7", 10,10,20)
        val radar = ObjetoC("Radar", 5,10,20)
        val senzu = ObjetoC("Senzu", 5,10,20)



        val aleatorio= (1..50).random()
        var objeto = ObjetoC()

        when(aleatorio){
            in 1..10-> {binding.objeto.setBackgroundResource(R.drawable.senzu)
                objeto = senzu
            }
            in 11..30-> {binding.objeto.setBackgroundResource(R.drawable.radar)
                objeto = radar
            }

            in 30..33 -> {binding.objeto.setBackgroundResource(R.drawable.dbuno)
                    objeto = db1
            }
            in 34..37-> {binding.objeto.setBackgroundResource(R.drawable.dbdos)
                    objeto = db2
            }
            in 38..41-> {binding.objeto.setBackgroundResource(R.drawable.dbtres_)
                    objeto = db3
            }
            in 42..45-> {binding.objeto.setBackgroundResource(R.drawable.dbcuatro_)
                    objeto = db4
            }
            in 46..47-> {binding.objeto.setBackgroundResource(R.drawable.dbcinco)
                    objeto = db5
            }
            in 48..49-> {binding.objeto.setBackgroundResource(R.drawable.dbseis)
                    objeto = db6
            }
            50-> {binding.objeto.setBackgroundResource(R.drawable.dbsiete)
                    objeto = db7
            }
        }

        //si posees las 7 dragon balls, aparecerá shenron
        if(pers.mochila.contains(db1) && pers.mochila.contains(db2) && pers.mochila.contains(db3) && pers.mochila.contains(db4) && pers.mochila.contains(db5) && pers.mochila.contains(db6) && pers.mochila.contains(db7)){
            binding.continuar.setOnClickListener(){
                val intent = Intent(this@Objeto, Shenron::class.java)
                startActivity(intent)
            }
        }

        //solo se puede recoger una bola de dragon de cada tipo
        binding.recoger.setOnClickListener {
            if(pers.getPesoMochila() >= objeto.peso){
                if(!pers.mochila.contains(objeto)){
                    pers.mochila.add(objeto)
                    pers.setPesoMochila(pers.getPesoMochila() - objeto.peso)
                    Toast.makeText(this, "Has recogido ${objeto.nombre}", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Ya tienes este objeto", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "No tienes espacio en la mochila", Toast.LENGTH_SHORT).show()
            }
        }
            binding.continuar.setOnClickListener {
            val editor = compartir.edit()
            persString = gson.toJson(pers)
            editor.putString("Personaje", persString)
            editor.apply()

            val intent = Intent(this@Objeto, Dado::class.java)
            startActivity(intent)

        }
    }
}
