package com.example.myfirstapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstapplication.screens.FirstScreen
import com.example.myfirstapplication.screens.SecondScreen
import com.example.myfirstapplication.screens.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route){
        composable(route = AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument("text") {
                type = NavType.StringType
            })){
            SecondScreen(navController, text = it.arguments?.getString("text"))
        }
    }

}

