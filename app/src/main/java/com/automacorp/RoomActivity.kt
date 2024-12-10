package com.automacorp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.automacorp.model.RoomDto
import com.automacorp.model.RoomViewModel
import com.automacorp.model.WindowDto
import com.automacorp.model.WindowStatus
import com.automacorp.service.RoomService
import com.automacorp.ui.theme.AutomacorpTheme
import java.lang.Math.round


class RoomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val param = intent.getStringExtra(MainActivity.ROOM_PARAM)
        val viewModel: RoomViewModel by viewModels()
        viewModel.room = RoomService.findByNameOrId(param)
        val room = RoomService.findByNameOrId(param)

        val navigateBack: () -> Unit = {
            startActivity(Intent(baseContext, MainActivity::class.java))

        }
        val onRoomSave: () -> Unit = {
            // ...
            if (viewModel.room != null) {
                val roomDto: RoomDto = viewModel.room as RoomDto
                RoomService.updateRoom(roomDto.id, roomDto)
                Toast.makeText(baseContext, "Room ${roomDto.name} was updated", Toast.LENGTH_LONG)
                    .show()
                startActivity(Intent(baseContext, MainActivity::class.java))
            }
        }

        setContent {
            AutomacorpTheme {
                Scaffold(
                    topBar = { AutomacorpTopAppBar("Rooms", navigateBack) },
                    floatingActionButton = { RoomUpdateButton(onRoomSave) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    if (viewModel.room != null) {
                        RoomDetail(viewModel, Modifier.padding(innerPadding))
                    } else {
                        NoRoom(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
//fun RoomDetail(roomDto: RoomDto, modifier: Modifier = Modifier) {
fun RoomDetail(model: RoomViewModel, modifier: Modifier = Modifier) {
    val room = model.room!!
    //  if (room != null) {
    Column(modifier = modifier.padding(16.dp)) {
//        var nameState by remember { mutableStateOf(name) }
        Text(
            text = stringResource(R.string.act_room_name),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
//            nameState,
//            onValueChange = { nameState = it },
//            placeholder = { Text(stringResource(R.string.act_room_name)) },
            room.name,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { model.room = room.copy(name = it) },
            placeholder = { Text(stringResource(R.string.act_room_name)) },
        )


        // Current Temperature Label and Value
        Text(
            text = stringResource(R.string.act_room_current_temperature),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = "${room.currentTemperature?.let { String.format("%.1f", it) } ?: "N/A"}°C",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Target Temperature Input Field
        Text(
            text = stringResource(R.string.act_room_target_temperature),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Slider(
            value = room.targetTemperature?.toFloat() ?: 18.0f,
            onValueChange = { model.room = room.copy(targetTemperature = it.toDouble()) },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 0,
            valueRange = 10f..28f
        )

        Text(text = (round((room.targetTemperature ?: 18.0) * 10) / 10).toString())
    }

    //}
}

@Composable
fun NoRoom(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.act_room_none),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun RoomUpdateButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = {
            Icon(
                Icons.Filled.Done,
                contentDescription = stringResource(R.string.act_room_save),
            )
        },
        text = { Text(text = stringResource(R.string.act_room_save)) }
    )
}


//
//@Preview(showBackground = true)
//@Composable
//fun RoomDetailPreview() {
//    AutomacorpTheme {
//        RoomDetail(RoomDto(1, name: hello, ))
//    }
//}

@Preview(showBackground = true)
@Composable
fun RoomDetailPreview() {
    val room = RoomDto(
        id = 1,
        name = "Conference Room",
        currentTemperature = 22.0,
        targetTemperature = 24.0,
        windows = listOf(WindowDto(id = 1, name = "North Window","Meeting Room",1, windowStatus = WindowStatus.CLOSED))
    )
    val viewModel = RoomViewModel().apply { this.room = room }
    AutomacorpTheme {
        RoomDetail(viewModel)
    }
}
