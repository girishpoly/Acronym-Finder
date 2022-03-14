package com.acronymtest.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.acronymtest.di.DaggerAppComponent
import com.acronymtest.model.FullFormList
import com.acronymtest.repo.AcronymRetrofitInstance
import com.acronymtest.ui.AcronymsListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : ViewModel() {
    @Inject
    lateinit var apiService: AcronymRetrofitInstance
    val showError = ObservableBoolean()
    val adapter = AcronymsListAdapter(arrayListOf())

    init {
        DaggerAppComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()

    private fun clearList() {
        showError.set(false)
        adapter.clearList()
    }

    /**
     * This method will be called to make an API request
     * Will update the full-forms recycler view with the response
     * @param shortForm search query string that we want to find acronym for
     */
    private fun fetchAcronymList(shortForm: String) {
        disposable.add(
            apiService.getFullForm(shortForm)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<FullFormList>>() {
                    override fun onError(e: Throwable) {
                        showError.set(true)
                        adapter.updateList(emptyList())
                    }

                    override fun onSuccess(list: List<FullFormList>) {
                        showError.set(false)
                        if (list.isNotEmpty()) adapter.updateList(list.first().fullForms)
                        else adapter.updateList(emptyList())
                    }
                })
        )
    }

    /**
     * Will be called whenever user enters text in the Search View
     * Since it is hooked to the onQueryTextChange, this will be called as the text in the Search View changes
     */
    fun searchText(text: String?): Boolean {
        return if (text.isNullOrBlank()) {
            fetchAcronymList("")
            false
        } else {
            fetchAcronymList(text)
            true
        }
    }

    /**
     * Will be called whenever user submits the query string in the Search View
     * Will check if the query string is null or empty and will the clear the full form list
     */
    fun watchText(text: String?): Boolean {
        if (text.isNullOrBlank()) clearList()
        return true
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}