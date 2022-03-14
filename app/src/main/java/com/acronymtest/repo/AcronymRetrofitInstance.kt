package com.acronymtest.repo

import com.acronymtest.di.DaggerAppComponent
import com.acronymtest.model.FullFormList
import io.reactivex.Single
import javax.inject.Inject

class AcronymRetrofitInstance {

    @Inject
    lateinit var api: AcronymApi

    init {
        DaggerAppComponent.create().inject(this)
    }

    fun getFullForm(shortForm: String): Single<List<FullFormList>> {
        return api.getFullForm(shortForm)
    }
}
