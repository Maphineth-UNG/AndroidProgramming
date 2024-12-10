package com.automacorp.service


import com.automacorp.model.RoomCommandDto
import com.automacorp.model.RoomDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


public interface RoomsApiService {
//    // Read all rooms
//    @GET("rooms/{id}")
//    fun findById(@Path("id") id: Long): Call<RoomDto>
//
//    @GET("rooms")
//    fun findAll(@Query("sort") sort: String): Call<List<RoomDto>>
//
//    // Read one room by its ID
//    @GET("rooms/{id}")
//    fun getRoomById(@Path("id") id: String): Call<RoomDto>
//
//    // Update a room
//    @PUT("rooms/{id}")
//    fun updateRoom(@Path("id") id: Long, @Body room: RoomCommandDto): Call<RoomDto>
//
//    // Create a new room
//    @POST("rooms")
//    fun createRoom(@Body room: RoomCommandDto): Call<RoomDto>
//
//    // Delete a room by its ID
//    @DELETE("rooms/{id}")
//    fun deleteRoom(@Path("id") id: String): Call<Void>


    @GET("rooms")
    fun findAll(): Call<List<RoomDto>>

    @GET("rooms/{id}")
    fun findById(@Path("id") id: Long): Call<RoomDto>

    @PUT("rooms/{id}")
    fun updateRoom(@Path("id") id: Long, @Body room: RoomCommandDto): Call<RoomDto>

    @POST("rooms")
    fun createRoom(@Body room: RoomCommandDto): Call<RoomDto>

    @DELETE("rooms/{id}")
    fun deleteRoom(@Path("id") id: Long): Call<Void>




}