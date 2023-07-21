package com.z9.jur.jetpackcomposemvvm.network.responses

import com.google.gson.annotations.SerializedName
import com.z9.jur.jetpackcomposemvvm.network.model.RecipeDto

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>
)