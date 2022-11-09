package com.denisvieira05.spaceapp.ui.launchlists

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.denisvieira05.spaceapp.ui.launchlists.LaunchListFragment
import com.denisvieira05.spaceapp.ui.launchlists.LaunchesSourceTypeEnum

class TabAdapter(fragment: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragment, lifecycle) {

    private val tabs = listOf(
        LaunchListFragment(LaunchesSourceTypeEnum.NEXT),
        LaunchListFragment(LaunchesSourceTypeEnum.PAST)
    )

    override fun getItemCount() = tabs.size

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }
}