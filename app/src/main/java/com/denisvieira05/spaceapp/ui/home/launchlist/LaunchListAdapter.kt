package com.denisvieira05.spaceapp.ui.home.launchlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.LaunchItemViewBinding
import com.denisvieira05.spaceapp.ui.home.launchlist.uimodel.LaunchItemUIModel

class LaunchListAdapter(private val context: Context?) : RecyclerView.Adapter<LaunchViewHolder>() {

    var list: List<LaunchItemUIModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        context?.let { holder.bind(list[position], it) }
    }

    override fun getItemCount() = list.size
}

class LaunchViewHolder(private val binding: LaunchItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: LaunchItemUIModel, context: Context) {
        binding.tvName.text = item.name
        binding.tvStatus.text = item.successText
        binding.tvDate.text = item.dateFormatted
        binding.tvNumber.text = item.flightNumber

        setImageOnImageView(item.imageUrl, context, binding.mainImage)
    }

    private fun setImageOnImageView(imageUrl: String?, context: Context, mainImage: ImageView) {
        Glide
            .with(context)
            .load(imageUrl)
            .placeholder(R.drawable.falcon_sat)
            .error(R.drawable.crs)
            .into(mainImage)
    }


    companion object {
        fun from(parent: ViewGroup): LaunchViewHolder {
            return LaunchViewHolder(
                LaunchItemViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}