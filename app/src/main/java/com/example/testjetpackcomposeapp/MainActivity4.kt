package com.example.testjetpackcomposeapp

import android.os.Bundle
import android.text.Layout
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity4 :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutContent()
//            BoxExample()
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout{
        val (button1, button2, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

//        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
//                start.linkTo(barrier)
                start.linkTo(button1.end, margin = 16.dp)
            }
        ) {
            Text("Button 2")
        }


    }

}

@Preview
@Composable
fun previewCL(){
    ConstraintLayoutContent()
//    BoxExample()
}

@Composable
fun BoxExample() {
    Box(Modifier.fillMaxSize()) {
        Text("This is first text", modifier = Modifier.align(Alignment.TopCenter))
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight()
                .width(
                    50.dp
                )
                .background(Color.Blue)
        )
        Text("This is second text", modifier = Modifier.align(Alignment.Center))
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            onClick = {}
        ) {
            Text("+")
        }
    }
}