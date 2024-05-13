package com.example.virginmoney.data.repository

import com.example.virginmoney.data.api.APIDetail
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.room.RoomItemModel
import retrofit2.http.GET

interface Repository {
    suspend fun getPeopleList(): ArrayList<PeopleItemModel>

    suspend fun getRoomList(): ArrayList<RoomItemModel>
}