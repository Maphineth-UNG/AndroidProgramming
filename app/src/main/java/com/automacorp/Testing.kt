import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.automacorp.AutomacorpTopAppBar
import com.automacorp.RoomActivity
import com.automacorp.model.RoomDto
import com.automacorp.service.ApiServices
import com.automacorp.ui.theme.AutomacorpTheme
import com.automacorp.ui.theme.PurpleGrey80

//package com.automacorp
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.core.content.ContextCompat.startActivity
//import com.automacorp.MainActivity.Companion.ROOM_PARAM
//import com.automacorp.model.RoomDto
//import com.automacorp.model.openRoom
////import com.automacorp.service.ApiServices
//import com.automacorp.service.RoomService
//import com.automacorp.ui.theme.AutomacorpTheme
//import com.automacorp.ui.theme.PurpleGrey80
////import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//
//
//class RoomListActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        val roomId = intent.getStringExtra(RoomListActivity.ROOM_PARAM)
//
//        val navigateBack: () -> Unit = {
//            startActivity(Intent(baseContext, MainActivity::class.java))
//        }
//
//        fun onClick () {
//
//        }
//
//
//
////        runCatching { // (1)
////            ApiServices.roomsApiService.findAll().execute()  // (2)
////        }
//
////        runCatching { // (1)
////            ApiServices.roomsApiService.findAll().execute()  // (2)
////        }
////            .onSuccess { // (3)
////                val rooms = it.body() ?: emptyList()
////                // Display the component with the list on room
////                setContent {
////                    RoomList(rooms, navigateBack, openRoom)
////                }
////            }
////            .onFailure {
////                setContent {
////                    RoomList(emptyList(), navigateBack, openRoom)
////                }
////                it.printStackTrace() // (4)
////                Toast.makeText(this, "Error on rooms loading $it", Toast.LENGTH_LONG).show() // (5)
////            }
//
//
//        setContent {
//            AutomacorpTheme {
//                Scaffold(
//                    topBar = { AutomacorpTopAppBar("Rooms", navigateBack) },
////                  floatingActionButton = { RoomUpdateButton(onRoomSave) },
//                    modifier = Modifier.fillMaxSize()
//                ) { innerPadding ->
//                    LazyColumn(
//                        contentPadding = PaddingValues(4.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp),
//                        modifier = Modifier.padding(innerPadding),
//                    ) {
//                        val rooms = RoomService.findAll()
//
////                        items(rooms, key = { it.id }) {
////                            RoomItem(
////                                room = it,
////                                modifier = Modifier
////                            )
////                        }
//                        items(rooms, key = { it.id }) {
//                            RoomItem(
//                                room = it,
////                                room = room,
//                                modifier = Modifier.clickable { openRoom(it.id) },
////                                onClick = { openRoom(context, it.id)}
//
//                            )
//
//                        }
//
//                    }
//                }
//            }
//        }
//
//    }
////    private fun openRoomDetail(roomId: String) {
////        val intent = Intent(this, RoomDetailActivity::class.java).apply {
////            putExtra(ROOM_PARAM, roomId)
////        }
////        startActivity(intent)
////    }
////
////    companion object {
////        const val ROOM_PARAM = "room_param"
////    }
//}
//
//
////class RoomListActivity : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContent {
////            AutomacorpTheme {
////                RoomListScreen()
////            }
////        }
////    }
////}
//
//@Composable
//fun RoomItem(room: RoomDto, modifier: Modifier = Modifier) {
//    Card(
//        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
//        border = BorderStroke(1.dp, PurpleGrey80)
////        modifier = modifier.clickable {onClick()}
//    ) {
//        Row(
//            modifier = modifier.padding(20.dp),
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            Column {
//                Text(
//                    text = room.name,
//                    style = MaterialTheme.typography.bodyLarge,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Target temperature : " + (room.targetTemperature?.toString()
//                        ?: "?") + "°",
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//            Text(
//                text = (room.currentTemperature?.toString() ?: "?") + "°",
//                style = MaterialTheme.typography.headlineLarge,
//                textAlign = TextAlign.Right,
//                modifier = Modifier.fillMaxSize()
//            )
//
//
//        }
//    }
//}
//
//@Composable
//fun RoomList(
//    rooms: List<RoomDto>,
//    navigateBack: () -> Unit,
//    openRoom: (id: Long) -> Unit
//) {
//    AutomacorpTheme {
//        Scaffold(
//            topBar = { AutomacorpTopAppBar("Rooms", navigateBack) }
//        ) { innerPadding ->
//            if (rooms.isEmpty()) {
//                Text(
//                    text = "No room found",
//                    modifier = Modifier.padding(innerPadding)
//                )
//            } else {
//                LazyColumn(
//                    contentPadding = PaddingValues(4.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp),
//                    modifier = Modifier.padding(innerPadding),
//                ) {
//                    items(rooms, key = { it.id }) {
//                        RoomItem(
//                            room = it,
//                            modifier = Modifier.clickable { openRoom(it.id) },
////                            onClick = {openRoom(context, it.id)}
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//
////fun openRoom(id: Long) {
////    val intent = Intent(this, RoomDetailActivity::class.java).apply {
////        putExtra("ROOM_ID", id) // Pass the room ID to the detail screen
////    }
////    startActivity(intent)
////}
//
//
//@Composable
//fun RoomListScreen() {
//    LazyColumn(
//        contentPadding = PaddingValues(4.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        modifier = Modifier
//    ) {
//        val rooms = RoomService.findAll()
//        items(rooms, key = { it.id }) {
//            RoomItem(
//                room = it,
//                modifier = Modifier
//            )
//        }
//
//
//    }
//}
//
//
//
////@Composable
////fun RoomItem(room: RoomDto, modifier: Modifier = Modifier, onClick: () -> Unit) {
////    Card(
////        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
////        border = BorderStroke(1.dp, PurpleGrey80),
////        modifier = modifier.clickable { onClick() }
////    ) {
////        Row(
////            modifier = modifier.padding(20.dp),
////            verticalAlignment = Alignment.CenterVertically,
////        ) {
////            Column {
////                Text(
////                    text = room.name,
////                    style = MaterialTheme.typography.bodyLarge,
////                    fontWeight = FontWeight.Bold
////                )
////                Text(
////                    text = "Target temperature : " + (room.targetTemperature?.toString() ?: "?") + "°",
////                    style = MaterialTheme.typography.bodySmall
////                )
////            }
////            Text(
////                text = (room.currentTemperature?.toString() ?: "?") + "°",
////                style = MaterialTheme.typography.headlineLarge,
////                textAlign = TextAlign.Right,
////                modifier = Modifier.fillMaxSize()
////            )
////        }
////    }
////}
//
//fun openRoom(context: Context, roomId: Long) {
//    val intent = Intent(context, RoomActivity::class.java).apply {
//        putExtra("ROOM_ID", roomId.toString())
//    }
//    context.startActivity(intent)
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun RoomItemPreview() {
//    AutomacorpTheme {
//        RoomItem(RoomService.ROOMS[0])
//    }
//}
//
// Version 2
//
//package com.automacorp
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.core.content.ContextCompat.startActivity
//import com.automacorp.MainActivity.Companion.ROOM_PARAM
//import com.automacorp.model.RoomDto
//import com.automacorp.model.openRoom
////import com.automacorp.service.ApiServices
//import com.automacorp.service.RoomService
//import com.automacorp.ui.theme.AutomacorpTheme
//import com.automacorp.ui.theme.PurpleGrey80
////import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//
//
//class RoomListActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val navigateBack: () -> Unit = {
//            startActivity(Intent(baseContext, MainActivity::class.java))
//        }
//
//        fun onClick () {
//
//        }
//
//        fun openRoom(roomId: String) {
//            val intent = Intent(this, RoomActivity::class.java)
//            intent.putExtra("ROOM_ID", roomId)
//            startActivity(intent)
//        }
//
//        setContent {
//            AutomacorpTheme {
//                Scaffold(
//                    topBar = { AutomacorpTopAppBar("Rooms", navigateBack) },
////                  floatingActionButton = { RoomUpdateButton(onRoomSave) },
//                    modifier = Modifier.fillMaxSize()
//                ) { innerPadding ->
//                    LazyColumn(
//                        contentPadding = PaddingValues(4.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp),
//                        modifier = Modifier.padding(innerPadding),
//                    ) {
//                        val rooms = RoomService.findAll()
//                        items(rooms, key = { it.id }) {
//                            RoomItem(
//                                room = it,
//                                modifier = Modifier.clickable { openRoom(it.id) },
//
//                                )
//
//                        }
//
//                    }
//                }
//            }
//        }
//
//    }
//}
//
//
//@Composable
//fun RoomItem(room: RoomDto, modifier: Modifier = Modifier) {
//    Card(
//        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
//        border = BorderStroke(1.dp, PurpleGrey80)
////        modifier = modifier
//    ) {
//        Row(
//            modifier = Modifier.padding(20.dp),
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            Column {
//                Text(
//                    text = room.name,
//                    style = MaterialTheme.typography.bodyLarge,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Target temperature : " + (room.targetTemperature?.toString()
//                        ?: "?") + "°",
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//            Text(
//                text = (room.currentTemperature?.toString() ?: "?") + "°",
//                style = MaterialTheme.typography.headlineLarge,
//                textAlign = TextAlign.Right,
//                modifier = Modifier.fillMaxSize()
//            )
//
//
//        }
//    }
//}
////
////@Composable
////fun RoomList(
////    rooms: List<RoomDto>,
////    navigateBack: () -> Unit,
////    openRoom: (id: Long) -> Unit
////) {
////    AutomacorpTheme {
////        Scaffold(
////            topBar = { AutomacorpTopAppBar("Rooms", navigateBack) }
////        ) { innerPadding ->
////            if (rooms.isEmpty()) {
////                Text(
////                    text = "No room found",
////                    modifier = Modifier.padding(innerPadding)
////                )
////            } else {
////                LazyColumn(
////                    contentPadding = PaddingValues(4.dp),
////                    verticalArrangement = Arrangement.spacedBy(8.dp),
////                    modifier = Modifier.padding(innerPadding),
////                ) {
////                    items(rooms, key = { it.id }) {
////                        RoomItem(
////                            room = it,
////                            modifier = Modifier.clickable { openRoom(it.id) },
////                        )
////                    }
////                }
////            }
////        }
////    }
////}
//
////fun openRoom(context: Context, roomId: Long) {
////    val intent = Intent(context, RoomActivity::class.java).apply {
////        putExtra("ROOM_ID", roomId.toString())
////    }
////    context.startActivity(intent)
////}
////@Preview(showBackground = true)
////@Composable
////fun RoomItemPreview() {
////    AutomacorpTheme {
////        RoomItem(RoomService.ROOMS[0])
////    }
////}
//
//


//


class RoomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun closeActivity() {
            finish()
        }
        val navigateBack: () -> Unit = ::closeActivity

        // Define openRoom function
        val openRoom: (Long) -> Unit = { id ->
            // Navigate to RoomDetailsActivity and pass the room ID as an extra
            val intent = Intent(this, RoomActivity::class.java)
            intent.putExtra("ROOM_ID", id)
            startActivity(intent)
        }

        setContent {
            AutomacorpTheme {
                runCatching { // (1)
                    ApiServices.roomsApiService.findAll().execute()  // (2)
                }
                    .onSuccess { // (3)
                        val rooms = it.body() ?: emptyList()
                        // Display the component with the list on room
                        setContent {
                            RoomList(rooms, navigateBack, openRoom)
                        }
                    }
                    .onFailure {
                        setContent {
                            RoomList(emptyList(), navigateBack, openRoom)
                        }
                        it.printStackTrace() // (4)
                        Toast.makeText(this, "Error on rooms loading $it", Toast.LENGTH_LONG).show() // (5)
                    }

            }
        }
    }
}


@Composable
fun RoomItem(room: RoomDto, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(1.dp, PurpleGrey80),
        modifier = modifier
    ) {
        Row(
            modifier = modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = room.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Target temperature : " + (room.targetTemperature?.toString() ?: "?") + "°",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                text = (room.currentTemperature?.toString() ?: "?") + "°",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun RoomList(
    rooms: List<RoomDto>,
    navigateBack: () -> Unit,
    openRoom: (id: Long) -> Unit
) {
    AutomacorpTheme {
        Scaffold(
            topBar = { AutomacorpTopAppBar("Rooms", navigateBack) }
        ) { innerPadding ->
            if (rooms.isEmpty()) {
                Text(
                    text = "No room found",
                    modifier = Modifier.padding(innerPadding)
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(innerPadding),
                ) {
                    items(rooms, key = { it.id }) {
                        RoomItem(
                            room = it,
                            modifier = Modifier.clickable { openRoom(it.id) },
                        )
                    }
                }
            }
        }
    }
}
