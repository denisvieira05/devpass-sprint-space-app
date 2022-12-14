package com.denisvieira05.spaceapp.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class LaunchListsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setupTabs()
    }

    private fun setupTabs() {
        binding.viewPagerTabs.adapter = TabAdapter(this.supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPagerTabs) { tab, position ->
            tab.text =
                when(position) {
                    0 -> getString(R.string.next)
                    1 -> getString(R.string.past)
                    else -> ""
                }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_settings -> {
                // start navigation to settings
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}