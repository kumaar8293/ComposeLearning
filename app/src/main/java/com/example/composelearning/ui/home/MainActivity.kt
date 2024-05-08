package com.example.composelearning.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// For Compose we extend ComponentActivity instead of AppCompactActivity
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Roughly equivalent to calling ComponentActivity.setContentView() with a ComposeView i.e.:
        setContent {
            greetingMessage(msg = "Nishant Brokerr")

        }
    }

    //We have to make our Method as Composable, it can be only used inside other composable function
    @Composable
    fun greetingMessage(msg: String) {
        Text(text = "Hello, Sadda Praa $msg")
    }

    //Preview is only use for the UI preview.
    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        greetingMessage(msg = "Sam Boxer")
    }

}