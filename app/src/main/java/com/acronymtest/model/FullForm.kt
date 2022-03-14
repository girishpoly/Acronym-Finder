package com.acronymtest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class FullForm(
    val freq: Int,
    @SerializedName("lf")
    val fullForm: String,
    val since: Int,
    val vars: List<Var>
) : Serializable