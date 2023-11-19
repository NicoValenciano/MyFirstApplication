package com.example.myfirstapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myfirstapplication.models.Age
import com.example.myfirstapplication.models.RetrofitClient
import com.example.myfirstapplication.navigation.AppScreens
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController){
    Scaffold (topBar = {
        TopAppBar( {
            Text(text = "FirstScreen")
        })
    }){
    }
        BodyContent(navController)
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContent( navController: NavController,modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Surface(color = Color.White) {
        Column (modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center ,horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hola, ingresá tu nombre y la api Agify.io va a predecir tu edad",
                modifier = modifier.padding(24.dp),
                fontSize = 40.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Ingresar nombre") }
            )
            Button(
                onClick = {
                    val retrofitTraer = RetrofitClient.consumirApi.getAge(name)

                    retrofitTraer.enqueue(object : Callback<Age> {
                        override fun onResponse(call: Call<Age>, response: Response<Age>) {
                            val ageValue = response.body()?.age
                            text = ageValue?.toString() ?: "Edad no disponible"
                        }
                        override fun onFailure(call: Call<Age>, t: Throwable){
                            text = ("Error al consultar Api Rest")
                        }
                    })

                    if (text.isNotBlank()) {
                        navController.navigate(AppScreens.SecondScreen.route + "/${text}")
                    }
                },
                modifier = modifier.padding(24.dp)){
                    Text("Enviar")
            }
        }
    }
}

