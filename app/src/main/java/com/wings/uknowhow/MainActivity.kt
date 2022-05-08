package com.wings.uknowhow

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
                    Conversation(getSampleData().conversationSample)
//                    MessageCard(Message("Hyeok", "Jetpack Compose"))
                }
            }
        }
    }


}

data class SampleData(val conversationSample: List<Message>)

fun getSampleData(): SampleData {
    return SampleData(
        arrayListOf<Message>(
            Message("Hyeok", "Hello guys"),
            Message("Hye", "Hello guys"),
            Message(
                "ok",
                "this is my first compose project.\nthis is my first compose project.\nthis is my first compose project." +
                        "\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project." +
                        "\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project." +
                        "\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project."
            ),
            Message("eok", "guys"),
            Message("ffffk", "test"),
            Message("powerovjer", "hi")
        )
    )
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

        // variable to remember states
        var isExpanded: Boolean by remember { mutableStateOf(false) }
        // surfaceColor by remember state
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )
        // Column -> Vertical
        Column {
            Text(
                modifier = Modifier.clickable {
                   println(msg.author)
                },
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(Modifier.height(4.dp))   // Vertical Space

            // Surface is such like a RelativeLayout(size of wrap_contents)
            Surface(
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded    // Toggle a state of expanded
                }.also {
                    Modifier
                        .animateContentSize()
                        .padding(1.dp)
                },
                shape = MaterialTheme.shapes.small,
                elevation = 1.dp,
                color = surfaceColor
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false, name = "Dark Mode")
@Composable
fun DefaultPreview() {
    data class SampleData(val conversationSample: List<Message>)

    val sampleData = SampleData(
        arrayListOf<Message>(
            Message("Hyeok", "Hello guys"),
            Message("Hye", "Hello guys"),
            Message(
                "ok",
                "this is my first compose project.\nthis is my first compose project.\nthis is my first compose project.\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project.\n" +
                        "this is my first compose project."
            ),
            Message("eok", "guys"),
            Message("ffffk", "test"),
            Message("powerovjer", "hi")
        )
    )

    UknowhowTheme {
//        MessageCard(Message("Hyeok's", "Jetpack Compose"))
        Conversation(messages = sampleData.conversationSample)
    }
}