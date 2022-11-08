package com.denisvieira05.spaceapp

import com.denisvieira05.spaceapp.model.LaunchItem
import retrofit2.Call
import retrofit2.http.GET

interface LaunchItemsService {

    @GET("launches/upcoming")
    fun getNextLaunches() : Call<List<LaunchItem>>
}