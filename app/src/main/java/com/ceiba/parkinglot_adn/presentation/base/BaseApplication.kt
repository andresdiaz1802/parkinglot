package com.ceiba.parkinglot_adn.presentation.base

import android.app.Application
import android.content.Context
import com.ceiba.parkinglot_adn.injection.ApplicationComponent
import com.ceiba.parkinglot_adn.injection.DaggerApplicationComponent
import com.ceiba.parkinglot_adn.injection.DataModule

class BaseApplication : Application() {
    private lateinit var appComponent: ApplicationComponent
    private lateinit var context: Context

    override fun onCreate() {
        context = applicationContext
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().dataModule(DataModule()).build()
    }

    fun getAppComponent(): ApplicationComponent = appComponent
    fun getContext(): Context = context
}