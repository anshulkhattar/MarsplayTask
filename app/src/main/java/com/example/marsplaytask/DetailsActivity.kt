package com.example.marsplaytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import android.text.method.ScrollingMovementMethod
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var i=intent
        id.text=i.getStringExtra("id")
        titled.text=i.getStringExtra("title")
        journal.text=i.getStringExtra("journal")
        date.text=i.getStringExtra("publicationDate")
        eissn.text=i.getStringExtra("eissn")
        val arr=i.getStringArrayListExtra("authorDisplay")
        authors.text=arr.toString()
        desc.text=i.getStringArrayListExtra("abstract").toString()

        desc.setMovementMethod(ScrollingMovementMethod())
    }
}
