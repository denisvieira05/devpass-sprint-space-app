package com.denisvieira05.spaceapp.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("patch")
    val patch: Patch,
)