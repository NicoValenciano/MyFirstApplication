package com.example.myfirstapplication.navigation

sealed class AppScreens(val route: String){
    object SplashScreen: AppScreens("splash_screen")
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
}
