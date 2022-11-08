package com.denisvieira05.spaceapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.denisvieira05.spaceapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

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