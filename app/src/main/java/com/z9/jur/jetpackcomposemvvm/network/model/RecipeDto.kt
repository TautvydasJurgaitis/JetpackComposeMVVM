package com.z9.jur.jetpackcomposemvvm.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto(

    @SerializedName("pk")
    var pk: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("publisher")
    var publisher: String,

    @SerializedName("featured_image")
    var featuredImage: String,

    @SerializedName("rating")
    var rating: Int,

    @SerializedName("source_url")
    var sourceUrl: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("cooking_instructions")
    var cookingInstructions: String,

    @SerializedName("ingredients")
    var ingredients: List<String>?,

    @SerializedName("date_added")
    var dateAdded: String,

    @SerializedName("date_updated")
    var dateUpdated: String
)