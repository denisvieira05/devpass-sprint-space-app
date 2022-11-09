package com.denisvieira05.spaceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denisvieira05.spaceapp.databinding.FragmentNextLaunchesBinding
import com.denisvieira05.spaceapp.model.LaunchItem
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextLaunchesListFragment(private val source: LaunchesSourceTypeEnum) : Fragment() {

    private lateinit var _binding: FragmentNextLaunchesBinding
    private val binding get() = _binding

    private lateinit var adapter: LaunchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNextLaunchesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LaunchListAdapter(context)
        binding.mainRecylerView.layoutManager = LinearLayoutManager(context)
        binding.mainRecylerView.adapter = adapter

        requestData()
    }

    private fun requestData() {
        val retrofitClient = NetworkUtils().getRetrofitInstance("https://api.spacexdata.com/v5/")
        val service = retrofitClient.create(LaunchItemService::class.java)

        val callback = when(source) {
            LaunchesSourceTypeEnum.NEXT -> service.getNextLaunches()
            LaunchesSourceTypeEnum.PAST -> service.getPastLaunches()
        }

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
}