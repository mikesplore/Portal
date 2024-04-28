package com.mike.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Units(navController: NavController) {
    Column(
        modifier = Modifier
            .background(brush = brush)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Row(
            modifier = Modifier
                .absolutePadding(0.dp, 30.dp)
                .height(50.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select Unit to Explore",
                style = TextStyle(),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 10.dp) // Push the title lower
            )
        }

        // Units
        Column {
            for (i in 1..7) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(300.dp)
                        .height(70.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xff39A7FF))
                ) {
                    Text(text = "Unit $i")
                }
            }
        }

        // Continue button
        Button(
            onClick = { navController.navigate("start") },
            modifier = Modifier
                .absolutePadding(0.dp, 50.dp)
                .width(300.dp)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xff3559E0))
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview
@Composable
fun unitspreview(){
    Units(navController = rememberNavController())
}