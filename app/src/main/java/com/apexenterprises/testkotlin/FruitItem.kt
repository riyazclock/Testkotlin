package com.apexenterprises.testkotlin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FruitItem(item: FruitModel) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = item.name, style = MaterialTheme.typography.titleMedium)
        Text(text = "Mango: ${item.mango}")
        Text(text = "Apple: ${item.apple}")
        Text(text = "Total: ${item.total()}", style = MaterialTheme.typography.bodyLarge)
    }
}