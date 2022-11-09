package com.denisvieira05.spaceapp

import com.denisvieira05.spaceapp.model.LaunchItem
import retrofit2.Call
import retrofit2.http.GET

interface LaunchItemService {

    @GET("launches/upcoming")
    fun getNextLaunches() : Call<List<LaunchItem>>

    @GET("launches/past")
    fun getPastLaunches() : Call<List<LaunchItem>>
}