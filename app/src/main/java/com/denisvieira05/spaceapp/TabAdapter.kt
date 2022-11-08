package com.denisvieira05.spaceapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragment: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragment, lifecycle) {

    private val tabs = listOf(
        NextLaunchesListFragment(),
        NextLaunchesListFragment()
    )

    override fun getItemCount() = tabs.size

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }
}