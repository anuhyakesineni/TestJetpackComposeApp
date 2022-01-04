package com.example.testjetpackcomposeapp

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testjetpackcomposeapp.ui.theme.TestJetpackComposeAppTheme
import java.time.format.TextStyle

class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank, container, false)
        return ComposeView(requireContext()).apply {
            setContent {
                TestJetpackComposeAppTheme {
                    holo()

                }
            }

        }
    }
}

@Composable
fun holo() {

    val c = LocalContext.current
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }


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



        Row (modifier = Modifier.height(52.dp)){
//            ProvideTextStyle(androidx.compose.ui.text.TextStyle(color = Color.White) ) {
                OutlinedTextField(

                    value = inputvalue.value,

                    maxLines = 1,
//                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),



                onValueChange = { inputvalue.value = it },
//                    label = { Text(text = "Eg:12345")},
                    placeholder = { Text(
                        text = "Eg:12345",
//                        fontSize = 13.sp
                    ) },

                    modifier = Modifier.background(Color.White)


                )




            Button(  onClick = {
                Toast.makeText(c, "Clicked", Toast.LENGTH_SHORT).show()
                var code = inputvalue.component1().text
                if(code.isEmpty())
                    Toast.makeText(c, "Enter valid coupon code", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(c, code, Toast.LENGTH_SHORT).show()

            },

                modifier = Modifier
                    .height(50.dp)) {
//                Image(painter = painterResource(id = R.drawable.hologram_button_bg), contentDescription ="Loading bg img" )

                Text(text = "APPLY", color = Color.Yellow)

            }



        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = stringResource(id = R.string.hologram_notes),

            modifier = Modifier.padding(10.dp)
        )






    }
}

@Preview
@Composable
fun hollogramPreview(){
    holo()
}





