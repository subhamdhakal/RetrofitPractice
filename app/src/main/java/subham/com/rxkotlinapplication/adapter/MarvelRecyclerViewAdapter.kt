package subham.com.rxkotlinapplication.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import subham.com.rxkotlinapplication.Model.MarvelModel
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.databinding.ItemMarvelRecyclerViewItemBinding
import subham.com.rxkotlinapplication.viewmodel.MarvelRecyclerViewModel
import kotlin.coroutines.experimental.coroutineContext

class MarvelRecyclerViewAdapter(var listOfModel:List<MarvelModel>):RecyclerView.Adapter<MarvelRecyclerViewAdapter.MarvelRecyclerViewViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelRecyclerViewViewHolder {
        val binding:ItemMarvelRecyclerViewItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_marvel_recycler_view_item,parent,false)
        return MarvelRecyclerViewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfModel.size
    }

    override fun onBindViewHolder(holder: MarvelRecyclerViewViewHolder, position: Int) {
        holder.bind(listOfModel[position])

    }

    inner class MarvelRecyclerViewViewHolder(val binding: ItemMarvelRecyclerViewItemBinding):RecyclerView.ViewHolder(binding.root){
        val viewModel:MarvelRecyclerViewModel=MarvelRecyclerViewModel()
        fun bind(item:MarvelModel){
            viewModel.marvelModel=item
            binding.viewModel=viewModel
        }

    }
}