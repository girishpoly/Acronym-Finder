package com.acronymtest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Var(
    val freq: Int,
    @SerializedName("lf")
    val meaning: String,
    val since: Int
) : Serializable