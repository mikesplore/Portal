package com.mike.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun mainScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = brush),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        title()
        mainscreen()
        LoadingScreen(navController = navController)

    }
}
@Composable
fun title(){
    Column (modifier = Modifier
        .height(300.dp)
        .width(200.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "CLASS PORTAL",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                shadow = shaddow
            )
        )

    }
}
@Composable
fun mainscreen(){

    Column (modifier = Modifier
        .width(350.dp)
        .height(200.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color(0xff39A7FF).copy(alpha = 0.8f))
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "BACHELORS OF SCIENCE",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                shadow = shaddow
            )
        )
        Text(text = "IN",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                textAlign = TextAlign.Center,
                shadow = shaddow
            )
        )

        Text(text = "COMPUTER SCIENCE",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                shadow = shaddow
            )
        )

    }

}


@Composable
fun LoadingScreen(navController: NavController) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000) // Delay for 3 seconds
        isLoading = false // Set isLoading to false after the delay
    }

    if (isLoading) {
        // Show the loading indicator
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.Blue, // Customize the color if needed
                strokeWidth = 4.dp // Customize the stroke width if needed
            )
        }
    } else {
        // Navigate to the "login" destination
        navController.navigate("login")
    }
}


@Preview
@Composable
fun mypreview(){
    mainScreen(navController = rememberNavController())
}
