package com.jorgila.dragonballapp.di

import com.jorgila.dragonballapp.domain.repository.Repository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DiHelper : KoinComponent {
    val repository: Repository by inject()
}