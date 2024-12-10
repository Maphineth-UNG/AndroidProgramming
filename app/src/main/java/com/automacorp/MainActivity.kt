package com.automacorp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.automacorp.ui.theme.AutomacorpTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val ROOM_PARAM = "com.automacorp.room.attribute"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val param = intent.getStringExtra(MainActivity.ROOM_PARAM)


//        val onButtonClick: () -> Unit = {
//            // Here you can access to the activity state (ie baseContext)
//            Toast.makeText(baseContext, "Hello button", Toast.LENGTH_LONG).show()
//        }

        // Action to do when the button is clicked
        val onSayHelloButtonClick: (name: String) -> Unit = { name ->
//            Toast.makeText(baseContext, "Hello $name", Toast.LENGTH_LONG).show()
            val intent = Intent(this, RoomActivity::class.java).apply {
                putExtra(ROOM_PARAM, name)
            }
            startActivity(intent)
        }
        setContent {
            AutomacorpTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
//                        name = "Android",
//                        onClick = onButtonClick,
                        onClick = onSayHelloButtonClick,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(onClick: (name: String) -> Unit,  modifier: Modifier = Modifier) {
//fun Greeting(name: String, onClick: () -> Unit,  modifier: Modifier = Modifier) {
    Column {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//        Text(
//            text = "Welcome on automacorp the app to manage building windows",
//            modifier = modifier
//        )

//        Text(
//            stringResource(R.string.act_main_welcome),
//            textAlign = TextAlign.Center
//        )
//
//        Button(onClick = onClick) {
//            Text(
//                text = "open",
//                modifier = modifier
//            )
//        }

        AppLogo(Modifier.padding(top = 32.dp).fillMaxWidth())
        Text(
            stringResource(R.string.act_main_welcome),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

//        OutlinedTextField(
//            "",
//            onValueChange = { println("value of the field : $it") },
//            modifier = Modifier.padding(24.dp).fillMaxWidth()
//        )

        var name by remember { mutableStateOf("") }

//        OutlinedTextField(
//            name,
//            onValueChange = { name = it },
//            modifier = Modifier.padding(24.dp).fillMaxWidth()
//        )

        OutlinedTextField(
            name,
            onValueChange = { name = it },
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            placeholder = {
                Row {
                    Icon(
                        Icons.Rounded.AccountCircle,
                        modifier = Modifier.padding(end = 8.dp),
                        contentDescription = stringResource(R.string.act_main_fill_name),
                    )
                    Text(stringResource(R.string.act_main_fill_name))
                }
            })

//        OutlinedTextField(
//            name,
//            onValueChange = { name = it },
//            modifier = Modifier.padding(24.dp).fillMaxWidth(),
//            placeholder = {
//                Text(stringResource(R.string.act_main_fill_name))
//            })

        Button(
            onClick = { onClick(name) },
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(R.string.act_main_open))
        }
    }

//    Button(onClick = onClick) {
//        Text(
//            text = "My first button",
//            modifier = modifier
//        )
//    }
}


//@Composable
//fun text {
//    Text(
//        stringResource(R.string.act_main_welcome),
//        textAlign = TextAlign.Center
//    )
//}

@Composable
fun AppLogo(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.ic_logo),
        contentDescription = stringResource(R.string.app_logo_description),
        modifier = modifier.paddingFromBaseline(top = 100.dp).height(80.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutomacorpTheme {
//        Greeting("Android", onClick = {})
        Greeting(onClick = {})
    }

}