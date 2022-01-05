package com.example.testjetpackcomposeapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var l = ArrayList<String>()
        for (i in 1..10)
            l.add("name"+i)

        setContent {
//            TestJetpackComposeAppTheme {
//                getView(s = "All")
//
//
//            }

            listDisplay(l)
        }
    }

}
@Composable
fun getView(s:String){
    val c = LocalContext.current

    Row() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground)
            , contentDescription ="Loading image",
        modifier = Modifier
            .size(250.dp)
            .clip(CircleShape))



        Column(modifier = Modifier
            .padding(all = 10.dp)
            .clickable {  }) {
            Text(
                text = "Hi " + s,
                color = MaterialTheme.colors.secondary,

            )


            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { Toast.makeText(c, "Clicked", Toast.LENGTH_SHORT).show() },
            ) {
                Text(text = "Button")


            }
        }
    }

}

@Preview
@Composable
fun preview(){
    var l = ArrayList<String>()
    for (i in 1..10)
        l.add("name"+i)
    listDisplay(l)

}

@Composable
fun listDisplay(names:ArrayList<String>){
    LazyColumn{
        items(names.size){item->
            getView(s = names[item])

        }
    }
}
