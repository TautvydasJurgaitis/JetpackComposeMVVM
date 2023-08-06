package com.z9.jur.jetpackcomposemvvm.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.z9.jur.jetpackcomposemvvm.domain.model.Recipe
import com.z9.jur.jetpackcomposemvvm.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
private val recipeRepository: RecipeRepository,
@Named("auth_token") private val token: String): ViewModel() {
 //   private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    private val _recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val recipes: State<List<Recipe>> = _recipes

    init {
        searchRecipesByQuery()
    }

    fun searchRecipesByQuery() {

            viewModelScope.launch {
                try {
                    val result = recipeRepository.search(
                        token = token, page = 1, query = "chicken"
                    )
                    _recipes.value = result
                }
                catch (e: Exception) {
                    println("Klaida $e")
                }
            }



    }
}