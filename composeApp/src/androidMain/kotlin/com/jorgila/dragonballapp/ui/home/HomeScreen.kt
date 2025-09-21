package com.jorgila.dragonballapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
) {
    val viewModel: HomeViewModel = koinViewModel()
    val example by viewModel.example.collectAsState()
    Column {
        Text(text = example)
    }
}