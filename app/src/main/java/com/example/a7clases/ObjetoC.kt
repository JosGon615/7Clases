package com.example.a7clases

class ObjetoC {
    private var nombre: String = ""
    var peso: Int = 0
    var valor: Int = 0
    var vida: Int = 0

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

}