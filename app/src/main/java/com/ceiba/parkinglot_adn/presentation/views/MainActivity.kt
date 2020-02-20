package com.ceiba.parkinglot_adn.presentation.views

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.databinding.ActivityMainBinding
import com.ceiba.parkinglot_adn.presentation.base.BaseActivity
import com.ceiba.parkinglot_adn.presentation.presenters.MainPresenter

class MainActivity :
    BaseActivity(),
    MainPresenter.ViewPresenter {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        mainPresenter = MainPresenter(this, this)
        super.onCreate(savedInstanceState)
    }

    override fun getBinding(layout: Int): ActivityMainBinding {
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, layout)
        binding.view = mainPresenter
        return binding
    }

    override fun getLayout(): Int = R.layout.activity_main
}
