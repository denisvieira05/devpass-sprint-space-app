package com.denisvieira05.spaceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denisvieira05.spaceapp.databinding.LaunchItemViewBinding
import com.denisvieira05.spaceapp.model.LaunchItem

class LaunchListAdapter : RecyclerView.Adapter<LaunchViewHolder>() {

    lateinit var list : List<LaunchItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

class LaunchViewHolder(private val binding: LaunchItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: LaunchItem) {
        binding.tvName.text = item.name
    }

    companion object {
        fun from(parent: ViewGroup): LaunchViewHolder {
            return LaunchViewHolder(
                LaunchItemViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}