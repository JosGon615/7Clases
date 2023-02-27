package com.example.a7clases

import kotlin.collections.ArrayList

class Personaje{
    private var nombre: String = ""
    private var pesoMochila: Int = 0
    private var dinero: Int = 0
    private var raza: String = ""
    private var clase: String = ""
    private var fuerza: Int = 0
    private var defensa: Int = 0
    private var vida: Int = 0
    var mochila:ArrayList<ObjetoC> = ArrayList<ObjetoC>()

    constructor()

    constructor(nombre: String, pesoMochila: Int, raza: String, clase: String, fuerza: Int, defensa: Int, vida: Int, mochila: ArrayList<ObjetoC>){
        this.nombre = nombre
        this.pesoMochila = pesoMochila
        this.raza = raza
        this.clase = clase
        this.fuerza = fuerza
        this.defensa = defensa
        this.vida = vida
        this.mochila = mochila
    }

    var contador = 0
    var contadorDragonBall = 0

    fun getNombre(): String{
        return nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getDinero(): Int{
        return dinero
    }

    fun setDinero(dinero: Int){
        this.dinero = dinero
    }

    fun getPesoMochila(): Int{
        return pesoMochila
    }

    fun setPesoMochila(pesoMochila: Int){
        this.pesoMochila = pesoMochila
    }

    fun getRaza(): String{
        return raza
    }

    fun setRaza(raza: String){
        this.raza = raza
    }

    fun getClase(): String{
        return clase
    }

    fun setClase(clase: String){
        this.clase = clase
    }

    fun getFuerza(): Int{
        return fuerza
    }

    fun setFuerza(fuerza: Int){
        this.fuerza = fuerza
    }

    fun getDefensa(): Int{
        return defensa
    }

    fun setDefensa(defensa: Int){
        this.defensa = defensa
    }

    fun getVida(): Int{
        return vida
    }

    fun setVida(vida: Int){
        this.vida = vida
    }

    override fun toString(): String {
        return "Personaje(mochila=$mochila)"
    }

    fun atacar(enemigo: EnemigoC): Boolean {
        val random = (1..6).random()
        if (random > 3) {
            val damage = fuerza*2
            enemigo.setVida(enemigo.getVida() - damage)
            return true
        } else {
            return false
        }
    }



}

