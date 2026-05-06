package com.example.koffee.Adapter

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koffee.Domain.CategoryModel
import com.example.koffee.databinding.ViewholderCategoryBinding
import android.os.Handler
import com.example.koffee.R

class CategoryAdapter(val items: MutableList<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.Viewholder>(){
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    inner class Viewholder(val binding: ViewholderCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleCategory.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            Handler(Looper.getMainLooper()).postDelayed({

            }, 500)
        }
        if (selectedPosition == position) {
            holder.binding.titleCategory.setBackgroundResource(R.drawable.brown_full_corner_bg)
            holder.binding.titleCategory.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.titleCategory.setBackgroundResource(R.drawable.white_full_corner_bg)
            holder.binding.titleCategory.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }

    override fun getItemCount(): Int = items.size
}