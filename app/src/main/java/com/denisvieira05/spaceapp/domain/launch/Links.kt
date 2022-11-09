package com.denisvieira05.spaceapp.domain.launch

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("patch")
    val patch: Patch,
)