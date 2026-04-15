package com.apexenterprises.testkotlin

data class FruitModel(
    val name: String,
    val mango: Int,
    val apple: Int
) {
    fun total(): Int = mango + apple
}