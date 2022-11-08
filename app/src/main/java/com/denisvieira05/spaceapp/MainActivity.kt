package com.denisvieira05.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denisvieira05.spaceapp.databinding.ActivityMainBinding
import com.denisvieira05.spaceapp.model.LaunchItem
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LaunchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        adapter = LaunchListAdapter(this)
        binding.mainRecylerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.mainRecylerView.adapter = adapter

        requestData()
    }

    private fun requestData() {
        val retrofitClient = NetworkUtils().getRetrofitInstance("https://api.spacexdata.com/v5/")
        val service = retrofitClient.create(LaunchItemsService::class.java)

        val callback = service.getNextLaunches()

        binding.progressBar.isVisible = true

        callback.enqueue(object: Callback<List<LaunchItem>> {
            override fun onResponse(call: Call<List<LaunchItem>>, response: Response<List<LaunchItem>>) {
                response.body()?.let {
                    adapter.list = it
                    adapter.notifyDataSetChanged()
                }

                binding.progressBar.isVisible = false

                println("DNS: On Response ${response.body()}")
            }

            override fun onFailure(call: Call<List<LaunchItem>>, t: Throwable) {
                Snackbar.make(
                    binding.root,
                    "Error",
                    Snackbar.LENGTH_INDEFINITE
                ).apply {
                    setAction("Tentar Novamente") { requestData() }
                }
                binding.progressBar.isVisible = false

                println("DNS: On Response ERROR")
            }
        })

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