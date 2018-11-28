package subham.com.rxkotlinapplication.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import subham.com.rxkotlinapplication.database.PostsModel
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.databinding.ItemPostsBinding
import subham.com.rxkotlinapplication.viewmodel.PostsViewModel

class PostsAdapter(var context: Context, var posts: List<PostsModel>) :
    RecyclerView.Adapter<PostsAdapter.JsonPlaceHodlerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonPlaceHodlerViewHolder {
        var binding: ItemPostsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_posts, parent, false)
        return (JsonPlaceHodlerViewHolder(binding))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: JsonPlaceHodlerViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    inner class JsonPlaceHodlerViewHolder(var binding: ItemPostsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostsModel) {
            var postsViewModel = PostsViewModel(item)
            binding.viewModel=postsViewModel
        }
    }
}