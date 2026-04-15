package com.apexenterprises.testkotlin


import androidx.activity.compose.setContent


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val viewModel: FruitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("PR test successful");
        setContent {
            FruitScreen(viewModel)
        }
    }
}