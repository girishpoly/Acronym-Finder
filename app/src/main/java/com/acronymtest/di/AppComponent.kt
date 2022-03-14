package com.acronymtest.di

import com.acronymtest.repo.AcronymRetrofitInstance
import com.acronymtest.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
  fun inject(service: AcronymRetrofitInstance)
  fun inject(viewModel: MainViewModel)
}