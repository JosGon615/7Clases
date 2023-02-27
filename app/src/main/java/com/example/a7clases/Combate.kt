package com.example.a7clases

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.example.a7clases.databinding.ActivityCombateBinding

import com.google.gson.Gson

class Combate : AppCompatActivity() {
    private lateinit var binding: ActivityCombateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Personaje", MODE_PRIVATE)
        val gson = Gson()
        var persString = compartir.getString("Personaje", "")
        val pers = gson.fromJson(persString, Personaje::class.java)

        val vida = 500

        val senzu = ObjetoC("Senzu", 5,10,20)
        val enemigo = EnemigoC("Goku Black",vida)



        when (pers.getRaza()) {
            "saiyan" -> {
                binding.userCard.setImageResource(R.drawable.saiyancard)
                binding.userIcon.setImageResource(R.drawable.saiyanicon)
            }
            "namekiano" -> {
                binding.userCard.setImageResource(R.drawable.namekianocard)
                binding.userIcon.setImageResource(R.drawable.namekianoicon)
            }
            "terricola" -> {
                binding.userCard.setImageResource(R.drawable.terricolacard)
                binding.userIcon.setImageResource(R.drawable.terricolaicon)
            }
            "androide" -> {
                binding.userCard.setImageResource(R.drawable.androidecard)
                binding.userIcon.setImageResource(R.drawable.androideicon)
            }
        }

        binding.atacar.setOnClickListener() {
            if(pers.getVida() > 0 && enemigo.getVida() > 0){
                if(pers.atacar(enemigo)){
                    atacar(binding.vidaE, enemigo.getVida())
                }
                pers.setVida(pers.getVida() - ((20*2)/pers.getDefensa()))
                atacar(binding.vidaP, pers.getVida())
            }
            else{
                if(pers.getVida() <= 0){
                    Toast.makeText(this, "Has muerto", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Death::class.java)
                    startActivity(intent)
                }
                else{
                    binding.atacar.isEnabled = false
                    Toast.makeText(this, "El combate ha terminado, has ganado!", Toast.LENGTH_SHORT).show()
                    pers.contador += 1
                    if(pers.contador > 5){
                        pers.contador = 5
                    }
                }
            }
        }

        binding.huirC.setOnClickListener(){
            if(enemigo.getVida() > 0){
                if((1..6).random() > 4){
                    val editor = compartir.edit()
                    persString = gson.toJson(pers)
                    editor.putString("Personaje", persString)
                    editor.apply()

                    val intent = Intent(this, Dado::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "No has podido huir", Toast.LENGTH_SHORT).show()
                    pers.setVida(pers.getVida() - (20/pers.getDefensa()))
                    atacar(binding.vidaP, pers.getVida())
                    Toast.makeText(this, "El enemigo te ha golpeado", Toast.LENGTH_SHORT).show()
                }
            }else{
                val editor = compartir.edit()
                persString = gson.toJson(pers)
                editor.putString("Personaje", persString)
                editor.apply()

                val intent = Intent(this, Dado::class.java)
                startActivity(intent)
            }

        }

        binding.objetoC.setOnClickListener() {
            if(pers.getVida() < vida){
                var flag = false
                pers.mochila.forEach(){
                    if(it.nombre == "Senzu"){
                        flag = true
                    }
                }
                if(flag){
                    pers.setVida(pers.getVida() + 20)
                    if(pers.getVida() > vida){
                        pers.setVida(vida)
                    }
                    atacar(binding.vidaP, pers.getVida())
                    pers.mochila.remove(senzu)
                }
                else{
                    Toast.makeText(this, "No tienes semillas Senzu", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Tu vida esta al maximo", Toast.LENGTH_SHORT).show()
            }
        }
   }
    fun atacar(linearLayout: LinearLayout, nuevoAncho: Int) {
        val layoutParams = linearLayout.layoutParams
        layoutParams.width = nuevoAncho
        linearLayout.layoutParams = layoutParams as LinearLayout.LayoutParams
    }


}