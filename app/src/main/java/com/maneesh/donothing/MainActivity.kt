package com.maneesh.donothing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.maneesh.donothing.dataClasses.RandomColor
import com.maneesh.donothing.ui.theme.DoNothingTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoNothingTheme {
                // A surface container using the 'background' color from the theme
                var randomColor by remember {
                    mutableStateOf(getRandomColor())
                }
                val (red, green, blue) = randomColor
                val systemUiController: SystemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(color = Color(red,green,blue))
                Surface(modifier = Modifier.fillMaxSize()) {
                    Welcome(updateColor = { randomColor = getRandomColor() }, randomColor)
                }
            }
        }
    }
}

@Composable
fun Welcome(updateColor: () -> Unit, randomColor: RandomColor) {

    val (red, green, yellow) = randomColor
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Random color",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                backgroundColor = Color(red, green, yellow),
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(modifier = Modifier.padding(all = 8.dp).padding(bottom = 30.dp), onClick = {

                }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                    Text(text = "Random", color = Color.Black, fontSize = 20.sp)
                }
            }
        }

    )

}

fun getRandomColor(): RandomColor =
    RandomColor(red = Random.nextInt(256), green = Random.nextInt(256), blue = Random.nextInt(256))

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DoNothingTheme {
        Welcome(updateColor = { /*TODO*/ }, randomColor = getRandomColor())
    }
}