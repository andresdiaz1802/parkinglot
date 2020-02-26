package com.ceiba.parkinglot_adn.presentation.base

import android.app.Application
import android.content.Context
import com.ceiba.parkinglot_adn.injection.ApplicationComponent
import com.ceiba.parkinglot_adn.injection.DaggerApplicationComponent
import com.ceiba.parkinglot_adn.injection.RepositoryModule

class BaseApplication : Application() {
    init {
        instance = this
        applicationComponent = DaggerApplicationComponent
            .builder().repositoryModule(RepositoryModule()).build()
    }

    companion object {
        private var instance: BaseApplication? = null
        private var applicationComponent: ApplicationComponent? = null
        fun getContext(): Context = instance!!.applicationContext
        fun getApplicationComponent(): ApplicationComponent? = applicationComponent
    }
}