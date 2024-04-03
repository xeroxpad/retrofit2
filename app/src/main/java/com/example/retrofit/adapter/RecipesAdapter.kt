package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.databinding.ListItemBinding
import com.example.retrofit.retrofit.Recipes

class RecipesAdapter: ListAdapter<Recipes, RecipesAdapter.Holder>(Comparator()) {

    class Holder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)

        fun bind(recipes: Recipes) = with(binding) {
            title.text = recipes.name
            description.text = recipes.ingredients.toString()
        }
    }

    class Comparator: DiffUtil.ItemCallback<Recipes>(){
        override fun areItemsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}