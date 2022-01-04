package com.example.testjetpackcomposeapp

import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsProperties.EditableText
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.testjetpackcomposeapp.ui.theme.TestJetpackComposeAppTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            TestJetpackComposeAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//        }

        setContent {
            TestJetpackComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    hologram()


                }

            }

        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    TestJetpackComposeAppTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun hologram() {

    val c = LocalContext.current
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    Column(
        modifier = Modifier
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical,

                )
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.hologram_img),
            contentDescription = "Loading image",
            alignment = Alignment.Center,
            modifier = Modifier
                .height(80.dp)
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))



        Row (modifier = Modifier.height(50.dp)){
            TextField(

                value = inputvalue.value,

                maxLines = 1,




                onValueChange = { inputvalue.value = it },
                placeholder = { Text(
                    text = "Eg:12345",
                    fontSize = 13.sp
                    ) },

                modifier = Modifier.background(Color.White)

                )



            Button(onClick = {
                Toast.makeText(c, "Clicked", Toast.LENGTH_SHORT).show()
                             },
            modifier = Modifier
                .background(Color.White)
                .height(50.dp)) {
//                Image(painter = painterResource(id = R.drawable.hologram_button_bg), contentDescription ="Loading bg img" )
                Text(text = "APPLY")

            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = stringResource(id = R.string.hologram_notes),

        modifier = Modifier.padding(10.dp)
            )





    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun previewHollogram(){
    hologram()
}
