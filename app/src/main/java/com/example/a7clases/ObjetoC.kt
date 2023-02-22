package com.example.a7clases

class ObjetoC {
    private var nombre: String = ""
    private var peso: Int = 0
    private var valor: Int = 0
    private var vida: Int = 0

    constructor(nombre: String, peso: Int, valor: Int, vida: Int) {
        this.nombre = nombre
        this.peso = peso
        this.valor = valor
        this.vida = vida
    }

    constructor()

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getPeso(): Int {
        return peso
    }

    fun setPeso(peso: Int) {
        this.peso = peso
    }

    fun getValor(): Int {
        return valor
    }

    fun setValor(valor: Int) {
        this.valor = valor
    }

    fun getVida(): Int {
        return vida
    }

    fun setVida(vida: Int) {
        this.vida = vida
    }

}