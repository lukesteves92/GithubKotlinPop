package com.challenge.kotlinpop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.challenge.kotlinpop.core.navigation.HomeRoutes
import com.challenge.kotlinpop.features.details.screen.DetailsScreen
import com.challenge.kotlinpop.features.home.screen.HomeScreen

@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoutes.Home,
        modifier = modifier
    ) {
        composable<HomeRoutes.Home> {
            HomeScreen(
                navigateToDetails = { navHostController.navigate(HomeRoutes.Details) }
            )
        }

        composable<HomeRoutes.Details> {
            DetailsScreen(
                onBackPressed = { navHostController.popBackStack() }
            )
        }
    }
}