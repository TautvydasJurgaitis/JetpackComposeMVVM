package com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.z9.jur.jetpackcomposemvvm.domain.model.Recipe
import com.z9.jur.jetpackcomposemvvm.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
private val recipeRepository: RecipeRepository,
@Named("auth_token") private val token: String): ViewModel() {
    init {

    }

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())



}