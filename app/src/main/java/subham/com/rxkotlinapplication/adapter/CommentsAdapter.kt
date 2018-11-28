package subham.com.rxkotlinapplication.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import subham.com.rxkotlinapplication.database.CommentsModel
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.databinding.ItemCommentsBinding
import subham.com.rxkotlinapplication.viewmodel.CommentsViewModel

class CommentsAdapter(var context: Context, var commentsModel: List<CommentsModel>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding: ItemCommentsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_comments, parent, false)
        return CommentsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return commentsModel.size
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(commentsModel[position])
    }

    inner class CommentsViewHolder(var binding: ItemCommentsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommentsModel) {
            var commentsViewModel = CommentsViewModel(item)
            binding.viewModel = commentsViewModel
        }
    }
}