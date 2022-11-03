package com.denisvieira05.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denisvieira05.spaceapp.databinding.ActivityMainBinding
import com.denisvieira05.spaceapp.model.LaunchItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LaunchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LaunchListAdapter()
        adapter.list = listOf(
            LaunchItem(name = "Text01"),
            LaunchItem(name = "Text02"),
            LaunchItem(name = "Text03"),
            LaunchItem(name = "Text04"),
            LaunchItem(name = "Text05"),
            LaunchItem(name = "Text06")
        )

        binding.mainRecylerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.mainRecylerView.adapter = adapter
    }
}