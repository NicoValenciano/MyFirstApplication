package com.example.myfirstapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavHostController, text: String?){
    Scaffold (topBar = {
        TopAppBar({
            Row {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back", modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "SecondScreen")
            }
        })
    }){
        SecondBodyContent(navController, text)
    }

}

@Composable
fun SecondBodyContent(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        text?.let{
            Text(it,
                modifier = Modifier.padding(24.dp),
                fontSize = 40.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center)
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")

        }
    }
}
