package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profile(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Profile(modifier: Modifier = Modifier){
    val profilePic = painterResource(R.drawable.profile_stitch)

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = profilePic,
                contentDescription = null,
                //contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(420.dp)
                    .padding(start = 30.dp, end = 30.dp)
                    .padding(top = 20.dp)
                    //.padding(56.dp, 60.dp, 0.dp, 15.dp)
            )

        }
        NameAndDescription(name = "Engr. Solomon Terzungwe", jobDescription = "Software Engineer")
        
        Spacer(modifier = Modifier.height(100.dp))

        Contacts(R.drawable.png_transparent_blue_call_icon_dialer_android_google_play_telephone_phone_blue_text_telephone_call, handle = "+234 (703) 542 3346" )
        Contacts(icon = R.drawable.instagram_logo_2016_svg, handle = "@tripplet626")
        Contacts(icon = R.drawable.email_logo, handle = "terseertt@gmail.com")

    }

}

@Composable
fun NameAndDescription(name: String, jobDescription: String, modifier: Modifier = Modifier){

    Column {
        Text(
            text = name,
            modifier = Modifier
                .padding(top = 5.dp, start = 5.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 29.sp
        )
        Text(
            text = jobDescription,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
    }

}

@Composable
fun Contacts(icon: Int, handle: String, modifier: Modifier = Modifier){
    val rIcon = painterResource(icon)
    Row {
        Image(
            painter = rIcon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)

        )

        Text(
            text = handle,
            modifier = Modifier
                .padding(8.dp)
                .width(180.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardTheme {
        Greeting("Android")
    }
}