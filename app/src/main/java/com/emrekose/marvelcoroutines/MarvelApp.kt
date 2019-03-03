package com.emrekose.marvelcoroutines

import android.app.Application
import com.emrekose.marvelcoroutines.di.applicationModule
import com.emrekose.marvelcoroutines.util.debug
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        debug { Timber.plant( Timber.DebugTree()) }

        startKoin(this, listOf(applicationModule))
    }
}