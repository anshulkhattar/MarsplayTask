package com.example.marsplaytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView

    private var mApiService: ApiInterface? = null

    private var mAdapter: ArticleAdapter?= null;
    private var mArticle: MutableList<Article> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.rv)

        mApiService = RetrofitClient.client.create(ApiInterface::class.java)

        recyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = ArticleAdapter(this, mArticle, R.layout.list_item,recyclerView)
        recyclerView!!.adapter = mAdapter

        fetchArticleList()
    }

    private fun fetchArticleList() {
        //lateinit var map:HashMap<String,String>
        //map.put("title","DNA")
        val call = mApiService!!.getArticles("title:DNA","DNA")
        //val call = mApiService!!.getArticles("DNA")
        call.enqueue(object : Callback<MainPOJO> {

            override fun onResponse(call: Call<MainPOJO>, response: Response<MainPOJO>) {

                //Log.d("gf", "Total Questions: " + response.body()!!.docs!!.size)
                val questions = response.body()!!.response!!.docs
                if (questions != null) {
                    mArticle.addAll(questions)
                    mAdapter!!.notifyDataSetChanged()
                }

                //val jsonobj=JSONObject(questions.toString())

                Log.d("response",questions.toString())

            }


            override fun onFailure(call: Call<MainPOJO>, t: Throwable) {
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}