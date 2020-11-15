package com.udacity.shoestore.models.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.models.data.Shoe

class ShoeAdapter:ListAdapter<Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {
    class ViewHolder private constructor(val binding: ItemShoeListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(shoe: Shoe){
            binding.shoe = shoe
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup):ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemShoeListBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ShoeDiffCallback:DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }

}
