package com.z9.jur.jetpackcomposemvvm.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.z9.jur.jetpackcomposemvvm.R
import com.z9.jur.jetpackcomposemvvm.domain.model.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )

    ) {
        Column {
            recipe.featuredImage?.let { url ->
//                Image(
//                    painter = painterResource(id = R.drawable.ic_default_meal),
//                    contentDescription = "meal image",
//                    modifier = Modifier
//                        .align(alignment = Alignment.CenterHorizontally)
//                        .padding(top = 10.dp)
//                )

                AsyncImage(
                    model = url,
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.ic_default_meal),
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                        .height(225.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                     //   .height(255.dp)
                )
            }
            recipe.title?.let { title ->
                Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(
                           top = 12.dp, bottom = 12.dp,
                           start = 8.dp, end = 8.dp
                       )
                ) {
                    Text(text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = TextStyle(
                            fontSize = 26.sp
                        )
                    )
                    Text(text = recipe.rating.toString(),
                        Modifier.fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = TextStyle(
                            fontSize = 22.sp
                        )
                    )
                }
            }
        }

    }
}