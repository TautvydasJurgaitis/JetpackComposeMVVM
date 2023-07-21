package com.z9.jur.jetpackcomposemvvm.repository

import com.z9.jur.jetpackcomposemvvm.domain.model.Recipe

interface RecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

}