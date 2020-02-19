package com.ceiba.parkinglot_adn.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.ceiba.parkinglot_adn.databinding.ActivityMainBinding

abstract class BaseActivity :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        getBinding(getLayout())
    }

    abstract fun getBinding(layout: Int): ActivityMainBinding

    @LayoutRes
    abstract fun getLayout(): Int
}