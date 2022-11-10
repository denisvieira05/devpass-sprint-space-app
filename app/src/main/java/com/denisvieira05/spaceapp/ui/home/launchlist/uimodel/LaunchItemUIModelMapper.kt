package com.denisvieira05.spaceapp.ui.home.launchlist.uimodel

import android.content.Context
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.domain.launch.LaunchItem
import com.denisvieira05.spaceapp.utils.DateUtils
import com.denisvieira05.spaceapp.utils.DateUtils.convertToSimpleDateFormat

class LaunchItemUIModelMapper(private val context: Context) {

    private fun convert(item: LaunchItem) : LaunchItemUIModel {
        val dateFormatted = DateUtils.convertTimestampToDate(item.date)?.convertToSimpleDateFormat()

        return LaunchItemUIModel(
            item.name,
            getTextStatus(item.success),
            dateFormatted.orEmpty(),
            "#${item.flightNumber}",
            item.links.patch.small
        )
    }

    fun convert(items: List<LaunchItem>) : List<LaunchItemUIModel> {
        return items.map {
            this.convert(it)
        }
    }

    private fun getTextStatus(isSuccess: Boolean): String {
        return if (isSuccess) context.getString(R.string.success_message)
        else context.getString(R.string.failure_message)
    }
}