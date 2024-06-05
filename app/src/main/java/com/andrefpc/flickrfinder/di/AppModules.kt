package com.andrefpc.flickrfinder.di

import com.andrefpc.flickrfinder.api.FlickrApi
import com.andrefpc.flickrfinder.repository.FlickrRepository
import com.andrefpc.flickrfinder.repository.FlickrRepositoryImpl
import com.andrefpc.flickrfinder.ui.view.details.DetailsViewModel
import com.andrefpc.flickrfinder.ui.view.main.MainViewModel
import com.andrefpc.flickrfinder.util.CoroutineContextProvider
import com.andrefpc.flickrfinder.util.api.ApiUtil
import com.andrefpc.flickrfinder.util.api.ApiUtilImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            dispatcher = get(),
            flickrRepository = get()
        )
    }

    viewModel {
        DetailsViewModel(
            dispatcher = get()
        )
    }
}

val apiModule = module {
    single { createApi<FlickrApi>(retrofit = get()) }
}

val repositoryModule = module {
    single<FlickrRepository> {
        FlickrRepositoryImpl(flickrApi = get(), apiUtil = get())
    }
}

val utilModule = module {
    single<ApiUtil> {
        ApiUtilImpl()
    }
}

val remoteModule = module {
    single { provideOkHttpClient(context = get()) }
    single { provideRetrofit(okHttpClient = get()) }
}

val coroutineContextProviderModule = module {
    single { CoroutineContextProvider() }
}