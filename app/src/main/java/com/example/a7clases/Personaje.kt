package com.example.a7clases

class Personaje{
    var nombre: String = ""
    var pesoMochila: Int = 0
    var raza: String = ""
    var clase: String = ""
    var fuerza: Int = 0
    var defensa: Int = 0
    var vida: Int = 0
    var mochila:ArrayList<ObjetoC> = ArrayList<ObjetoC>()

    constructor()

    constructor(nombre: String, raza: String, clase: String, fuerza: Int, defensa: Int, vida: Int, mochila:ArrayList<ObjetoC>, pesoMochila: Int){
            this.nombre = nombre
            this.raza = raza
            this.clase = clase
            this.fuerza = fuerza
            this.defensa = defensa
            this.vida = vida
            this.mochila = ArrayList<ObjetoC>()
    }


    fun getNombre(): String{
        return nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
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

    fun getMochila(): ArrayList<ObjetoC>{
        return mochila
    }

    fun setMochila(mochila: ArrayList<ObjetoC>){
        this.mochila = mochila
    }







}

