package com.denisvieira05.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

//        adapter.list = listOf(
//            LaunchItem(name = "Text01"),
//            LaunchItem(name = "Text02"),
//            LaunchItem(name = "Text03"),
//            LaunchItem(name = "Text04"),
//            LaunchItem(name = "Text05"),
//            LaunchItem(name = "Text06")
//        )

        adapter = LaunchListAdapter()
        binding.mainRecylerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.mainRecylerView.adapter = adapter

        requestData()
    }

    private fun requestData() {
        val retrofitClient = NetworkUtils().getRetrofitInstance("https://api.spacexdata.com/v5/")
        val service = retrofitClient.create(LaunchItemsService::class.java)

        val callback = service.getNextLaunches()

//        "id": "6243aec2af52800c6e91925d"
        callback.enqueue(object: Callback<LaunchItem> {
            override fun onResponse(call: Call<LaunchItem>, response: Response<LaunchItem>) {
                response.body()?.let {
                    adapter.list = listOf(
                        it
                    )
                    adapter.notifyDataSetChanged()
                }

                println("DNS: On Response ${response.body()}")
            }

            override fun onFailure(call: Call<LaunchItem>, t: Throwable) {
                Snackbar.make(
                    binding.root,
                    "Error",
                    Snackbar.LENGTH_INDEFINITE
                ).apply {
                    setAction("Tentar Novamente") { requestData() }
                }


                println("DNS: On Response ERROR")
            }
        })

    }
}