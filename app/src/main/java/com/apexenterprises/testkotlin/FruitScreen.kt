package com.apexenterprises.testkotlin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun FruitScreen(viewModel: FruitViewModel) {

    var name by remember { mutableStateOf("") }
    var mango by remember { mutableStateOf("") }
    var apple by remember { mutableStateOf("") }

    val list by viewModel.list.observeAsState(emptyList())
    val total by viewModel.total.observeAsState(0)

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = mango,
            onValueChange = { mango = it },
            label = { Text("Mango Count") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apple,
            onValueChange = { apple = it },
            label = { Text("Apple Count") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val mangoInt = mango.toIntOrNull() ?: 0
                val appleInt = apple.toIntOrNull() ?: 0

                viewModel.addItem(FruitModel(name, mangoInt, appleInt))

                name = ""
                mango = ""
                apple = ""
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Add")
        }

        Text(
            text = "Total: $total",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f) ) {

            items(list) { item ->
                FruitItem(item)
            }
        }
    }
}