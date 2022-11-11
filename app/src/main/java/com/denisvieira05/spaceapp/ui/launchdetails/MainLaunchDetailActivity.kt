package com.denisvieira05.spaceapp.ui.launchdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denisvieira05.spaceapp.databinding.ActivityLaunchDetailsBinding
import com.denisvieira05.spaceapp.ui.home.launchlist.LaunchListFragment.Companion.LAUNCH_NAME_KEY
import com.google.android.material.snackbar.Snackbar

class MainLaunchDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launchName = intent.getStringExtra(LAUNCH_NAME_KEY)

        Snackbar.make(binding.root, "LaunchName: $launchName", Snackbar.LENGTH_LONG).show()
    }
}