package com.example.marsplaytask

import com.google.gson.annotations.SerializedName

class Article{
    @SerializedName("id") val id : String=""
    @SerializedName("journal") val journal : String=""
    @SerializedName("eissn") val eissn : String=""
    @SerializedName("publication_date") val publication_date : String=""
    @SerializedName("article_type") val article_type : String=""
    @SerializedName("author_display") val author_display : ArrayList<String>? = null
    @SerializedName("abstract") val abstract : ArrayList<String>?=null
    @SerializedName("title_display") val title_display : String=""
    @SerializedName("score") val score : Double=0.0
}