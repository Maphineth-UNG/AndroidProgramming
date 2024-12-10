package com.automacorp.model


class RoomList(
    val rooms: List<RoomDto> = emptyList(),
//    val rooms: List<RoomDto>,

    val error: String? = null
)