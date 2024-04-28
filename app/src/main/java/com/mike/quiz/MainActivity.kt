package com.mike.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            mainScreen()
        }
    }
}

val brush  = Brush.verticalGradient(
    colors = listOf(
        Color(0xffEEF5FF),
        Color(0xff40A2E3)
    )
)
val shaddow = Shadow(
    color = Color.Gray,
    offset = Offset(5f, 5f),
    blurRadius = 5f
)

@Composable
fun mainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = brush),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        title()
        mainscreen()
        LoadingScreen()

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
            .background(Color(0xff40A2D8).copy(alpha = 0.8f))
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
fun LoadingScreen() {
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(5000) // Delay for 5 seconds
        isLoading = true // Set isLoading to true after the delay
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.Blue, // Customize the color if needed
                strokeWidth = 4.dp // Customize the stroke width if needed
            )
        }
    }
}

@Preview
@Composable
fun mypreview(){
mainScreen()
}