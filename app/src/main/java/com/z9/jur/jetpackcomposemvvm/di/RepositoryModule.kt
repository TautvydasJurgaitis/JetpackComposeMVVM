package com.z9.jur.jetpackcomposemvvm.di

import com.z9.jur.jetpackcomposemvvm.network.RecipeService
import com.z9.jur.jetpackcomposemvvm.network.model.RecipeDtoMapper
import com.z9.jur.jetpackcomposemvvm.repository.RecipeRepository
import com.z9.jur.jetpackcomposemvvm.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}