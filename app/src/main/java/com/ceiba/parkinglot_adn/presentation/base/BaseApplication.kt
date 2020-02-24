package com.ceiba.parkinglot_adn.presentation.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: BaseApplication? = null
        fun getContext(): Context = instance!!.applicationContext
    }
}