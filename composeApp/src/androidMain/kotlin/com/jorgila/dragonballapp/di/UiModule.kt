package com.jorgila.dragonballapp.di

import com.jorgila.dragonballapp.ui.home.DetailViewModel
import com.jorgila.dragonballapp.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val uiModule = module {
    factoryOf(::HomeViewModel)
    factoryOf(::DetailViewModel)
}