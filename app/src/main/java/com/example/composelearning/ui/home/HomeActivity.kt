package com.example.composelearning.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composelearning.R

// For Compose we extend ComponentActivity instead of AppCompactActivity
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Roughly equivalent to calling ComponentActivity.setContentView() with a ComposeView i.e.:
        setContent {
           GreetingMessage(msg = "Nishant Brokerr")
        }
    }

    //We have to make our Method as Composable, it can be only used inside other composable function
    @Composable
    fun GreetingMessage(msg: String) {
        /** This is how get context inside any composable function **/
        val context = LocalContext.current
        Text(text = "Hello, Sadda Praa $msg",
            fontSize = 22.sp,
            /** We can read resource like this and similar way **/
            color = colorResource(id = R.color.purple_700),//
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                Toast.makeText(context, "Ki Haal Chal Praa", Toast.LENGTH_SHORT).show()
            }
        )
    }

    //Preview is only use for the UI preview.
    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        GreetingMessage(msg = "Sam Boxer")
    }

}