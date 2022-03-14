package com.acronymtest.di


import com.acronymtest.repo.AcronymApi
import com.acronymtest.repo.AcronymRetrofitInstance
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    private val BASE_URL = "http://www.nactem.ac.uk/software/acromine/"
    private val client = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }
        .let { OkHttpClient.Builder().addInterceptor(it).build() }

    @Provides
    fun provideApi(): AcronymApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(AcronymApi::class.java)
    }

    @Provides
    fun provideService(): AcronymRetrofitInstance {
        return AcronymRetrofitInstance()
    }
}