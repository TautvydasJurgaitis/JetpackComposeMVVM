package com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.z9.jur.jetpackcomposemvvm.R
import com.z9.jur.jetpackcomposemvvm.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                
                LazyColumn() {
                    itemsIndexed(
                        items = recipes
                    ) {index, recipe ->
                        RecipeCard(recipe = recipe, onClick = {findNavController().navigate(R.id.viewRecipe)})
                    }
                }
                
                /*
                for(recipe in recipes) {
                    println("${recipe.title}")
                }

                Column(modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())) {
                    Text(
                        text = "Recipes",
                        style = TextStyle(
                            fontSize = 21.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { findNavController().navigate(R.id.viewRecipe) }) {
                        Text(text = "Recipe")
                    }

                }
                 */
            }
        }
    }
}