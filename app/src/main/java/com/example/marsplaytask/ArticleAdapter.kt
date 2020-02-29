package com.example.marsplaytask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alespero.expandablecardview.ExpandableCardView
import kotlinx.android.synthetic.main.list_item.view.*
import retrofit2.Callback
import androidx.core.view.ViewCompat.setActivated
import android.transition.TransitionManager
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.view.*


class ArticleAdapter(private val context: Context, private val mArticle: List<Article>, private val mRowLayout: Int,val recyclerView: RecyclerView) : RecyclerView.Adapter<ArticleAdapter.QuestionViewHolder>() {

    var mExpandedPosition=-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return QuestionViewHolder(view)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onBindViewHolder(holder:QuestionViewHolder, position: Int) {
        //holder.positionNumber?.text = context.resources.getString("", position + 1)
        holder.title?.text = mArticle[position].title_display
        /*val isExpanded = position==mExpandedPosition;
        holder.containerView.button.setVisibility(if (isExpanded) View.VISIBLE else View.GONE)
        holder.itemView.isActivated = isExpanded
        holder.containerView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            TransitionManager.beginDelayedTransition(recyclerView)
            notifyDataSetChanged()
        }*/

        holder.readMoreButton.setOnClickListener {
            var intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra("id", mArticle[position].id)
            intent.putExtra("journal", mArticle[position].journal)
            intent.putExtra("eissn", mArticle[position].eissn)
            intent.putExtra("publicationDate", mArticle[position].publication_date)
            intent.putExtra("articleType", mArticle[position].article_type)
            intent.putStringArrayListExtra("authorDisplay", mArticle[position].author_display)
            intent.putStringArrayListExtra("abstract", mArticle[position].abstract)
            intent.putExtra("title", mArticle[position].title_display)
            intent.putExtra("score", mArticle[position].score)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mArticle.size
    }

    class QuestionViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val title = containerView.titleDisplay
        val readMoreButton=containerView.button
    }
}