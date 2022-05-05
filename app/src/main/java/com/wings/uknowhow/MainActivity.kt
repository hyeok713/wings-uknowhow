package com.wings.uknowhow

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wings.uknowhow.ui.theme.UknowhowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UknowhowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MessageCard(Message("Hyeok", "Jetpack Compose"))
                }
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Row -> Horizontal
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contract Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
        )

        Spacer(Modifier.width(8.dp))        // Horizontal Space

        // Column -> Vertical
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(Modifier.height(4.dp))   // Vertical Space

            // Surface is such like a RelativeLayout(size of wrap_contents)
            Surface(shape = MaterialTheme.shapes.small, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    UknowhowTheme {
        MessageCard(Message("Hyeok's", "Jetpack Compose"))
    }
}