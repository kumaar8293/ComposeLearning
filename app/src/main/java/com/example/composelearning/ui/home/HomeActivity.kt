package com.example.composelearning.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelearning.R

// For Compose we extend ComponentActivity instead of AppCompactActivity
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Roughly equivalent to calling ComponentActivity.setContentView() with a ComposeView i.e.:
        setContent {
            // GreetingMessage(msg = "Nishant Brokerr")   //1
            // SimpleUserCard() //2
            UserCardWithCardView() //3
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

    // =========== STEP 2 ==============
    @Composable
    fun SimpleUserCard() {
        //User for Horizontal Parent
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .border(1.dp, Color.Gray)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)

            )
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = stringResource(id = R.string.sample_string))
                Button(
                    onClick = {
                        Toast.makeText(context, "Ki Haal Chall Praa", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "View Profile")
                }
            }
        }
    }
    @Composable
    fun UserCardWithCardView() {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
            ,
            colors = CardDefaults.cardColors(containerColor = Color.White)

        ) {
            SimpleUserCard()
        }
    }

    //Preview is only use for the UI preview.
    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        /** 1st component **/
        //GreetingMessage(msg = "Sam Boxer")

        /** 2nd component **/
        // SimpleUserCard()

        /** 2nd component **/
        UserCardWithCardView()
    }

}