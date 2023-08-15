package com.z9.jur.jetpackcomposemvvm.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list.FoodCategory

@Composable
fun FoodCategoryChip(
    category: String,
    onExecuteSearch: (String) -> Unit
) {
    Row(
        modifier = Modifier.clickable { onExecuteSearch(category) }
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(8.dp)
        )
    }
}