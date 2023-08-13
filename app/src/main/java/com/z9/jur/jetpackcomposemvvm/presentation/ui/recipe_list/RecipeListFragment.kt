package com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
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
                val searchQuery = viewModel.recipeSearchQuery.value


                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Column  {
                        Row (
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                value = searchQuery,
                                onValueChange = {
                                viewModel.onRecipeSearchQueryChanged(it)
                            },
                                label = { Text(text = "Search")},
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search,
                                ),
                                keyboardActions = KeyboardActions(
                                    onSearch = {
                                        viewModel.searchRecipesByQuery(searchQuery)
                                        this.defaultKeyboardAction(ImeAction.Done)
                                    }
                                ),
                                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "")
                                },
                                maxLines = 1
                            )

                        }

                        Spacer(modifier = Modifier.padding(top = 10.dp))


                        LazyColumn() {
                            itemsIndexed(
                                items = recipes
                            ) { index, recipe ->
                                RecipeCard(
                                    recipe = recipe,
                                    onClick = { findNavController().navigate(R.id.viewRecipe) })
                            }
                        }
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