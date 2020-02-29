package com.example.marsplaytask

import com.google.gson.annotations.SerializedName

class Response{
    @SerializedName("numFound") val numfound : Int=0
    @SerializedName("start") val start : Int=0
    @SerializedName("maxScore") val maxscore : Double=0.0
    @SerializedName("docs") val docs : ArrayList<Article>?=null
}