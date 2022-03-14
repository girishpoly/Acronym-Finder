package com.acronymtest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class FullFormList(
    @SerializedName("lfs")
    val fullForms: List<FullForm>,
    @SerializedName("sf")
    val acronym: String
) : Serializable