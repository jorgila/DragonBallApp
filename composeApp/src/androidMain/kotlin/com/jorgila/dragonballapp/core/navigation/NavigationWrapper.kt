package com.jorgila.dragonballapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jorgila.dragonballapp.ui.detail.DetailScreen
import com.jorgila.dragonballapp.ui.home.HomeScreen

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home
    ){
        composable<Home>{
            HomeScreen(
                navigateToDetail = { id ->
                    navController.navigate(Detail(id))
                }
            )
        }
        composable<Detail> { backStackEntry ->
            val detail : Detail = backStackEntry.toRoute<Detail>()
            DetailScreen(detail.id)
        }
    }
}