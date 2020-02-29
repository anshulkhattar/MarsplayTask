package com.example.marsplaytask

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    /**
     * complete API : http://api.plos.org/search?q=title:DNA
     */


    @FormUrlEncoded
    @POST("search")
    fun getArticles(@Query("q") q:String,@Field("title") title:String): Call<MainPOJO>


}