package com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.z9.jur.jetpackcomposemvvm.R
import com.z9.jur.jetpackcomposemvvm.presentation.components.FoodCategoryChip
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

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Column {
                        Column {
                            Row(
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
                                    label = { Text(text = "Search") },
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
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = ""
                                        )
                                    },
                                    maxLines = 1
                                )
                            }

                            LazyRow(modifier = Modifier.fillMaxWidth()) {
                                itemsIndexed(items = FoodCategory.values()) { _, item ->
                                    
                                    FoodCategoryChip(category = item.value, onExecuteSearch = {
                                        viewModel.onRecipeSearchQueryChanged(it)
                                        viewModel.searchRecipesByQuery(it)
                                    })

//                                    Text(
//                                        text = item.value,
//                                        style = MaterialTheme.typography.bodyLarge,
//                                        color = MaterialTheme.colorScheme.onBackground,
//                                        modifier = Modifier.padding(8.dp)
//                                    )
                                }
                            }
                        }


                    //    Spacer(modifier = Modifier.padding(top = 10.dp))

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
            }
        }
    }
}