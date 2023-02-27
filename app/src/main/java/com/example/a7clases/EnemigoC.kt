package com.example.a7clases

import android.widget.Toast

class EnemigoC {
    private var nombre: String = ""
    private var vida: Int = 0


    constructor()

    constructor(nombre: String, vida: Int) {
        this.nombre = nombre

        this.vida = vida
    }

    fun getVida(): Int{
        return vida
    }

    fun setVida(vida: Int){
        this.vida = vida
    }
}