package com.apexenterprises.testkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {

    private val _list = MutableLiveData<List<FruitModel>>(emptyList())
    val list: LiveData<List<FruitModel>> = _list

    private val _total = MutableLiveData(0)
    val total: LiveData<Int> = _total

    fun addItem(model: FruitModel) {
        val current = _list.value?.toMutableList() ?: mutableListOf()
        current.add(model)
        _list.value = current

        calculateTotal(current)
    }

    private fun calculateTotal(list: List<FruitModel>) {
        val sum = list.sumOf { it.total() }
        _total.value = sum
    }
}