package com.example.virginmoney.data.api

import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.room.RoomItemModel
import retrofit2.http.GET



interface APIEndpoints {

    @GET(APIDetail.PEOPLE_ENDPOINT)
    suspend fun getPeopleList(): ArrayList<com.example.virginmoney.data.model.people.PeopleItemModel>

    @GET(APIDetail.ROOMS_ENDPOINT)
    suspend fun getRoomList(): ArrayList<RoomItemModel>


}