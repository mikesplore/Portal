package com.mike.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Thestart()
        }
    }
}

@Composable
fun Thestart(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start") {
        composable("start"){ mainScreen(navController = navController)}
        composable("login"){ Login(navController = navController)}

    }
}

val brush  = Brush.verticalGradient(
    colors = listOf(
        Color(0xffE0F4FF),
        Color(0xff87C4FF)
    )
)
val shaddow = Shadow(
    color = Color.Gray,
    offset = Offset(5f, 5f),
    blurRadius = 5f
)

@Preview
@Composable
fun mainPreview(){
    Thestart()
}


