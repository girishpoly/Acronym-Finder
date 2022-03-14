package com.acronymtest.repo

import com.acronymtest.model.FullFormList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymApi {
    @GET("dictionary.py")
    fun getFullForm(@Query("sf") shortForm: String): Single<List<FullFormList>>
}