package com.emrekose.marvelcoroutines.di

import com.emrekose.marvelcoroutines.data.remote.ApiService
import com.emrekose.marvelcoroutines.data.remote.RequestInterceptor
import com.emrekose.marvelcoroutines.repository.CharacterRepository
import com.emrekose.marvelcoroutines.ui.main.CharacterViewModel
import com.emrekose.marvelcoroutines.util.Constants
import com.emrekose.marvelcoroutines.util.debug
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {

    single { provideHttpLoggingInterceptor() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get()) }

    factory { CharacterRepository(get()) }

    viewModel { CharacterViewModel(get()) }
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

private fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.apply {
        debug { addInterceptor(httpLoggingInterceptor) }
        addInterceptor(RequestInterceptor())
    }
    return okHttpClient.build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}
