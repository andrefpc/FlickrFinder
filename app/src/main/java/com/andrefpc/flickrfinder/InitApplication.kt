package com.andrefpc.flickrfinder

import android.app.Application
import com.andrefpc.flickrfinder.di.apiModule
import com.andrefpc.flickrfinder.di.coroutineContextProviderModule
import com.andrefpc.flickrfinder.di.remoteModule
import com.andrefpc.flickrfinder.di.repositoryModule
import com.andrefpc.flickrfinder.di.utilModule
import com.andrefpc.flickrfinder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InitApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@InitApplication)
            modules(
                listOf(
                    viewModelModule,
                    apiModule,
                    repositoryModule,
                    utilModule,
                    remoteModule,
                    coroutineContextProviderModule
                )
            )
        }
    }
}