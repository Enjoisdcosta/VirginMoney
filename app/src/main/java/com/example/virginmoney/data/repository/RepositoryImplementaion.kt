package com.example.virginmoney.data.repository

import com.example.virginmoney.data.api.APIDetail
import com.example.virginmoney.data.api.APIEndpoints
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.room.RoomItemModel
import javax.inject.Inject

class RepositoryImplementaion @Inject constructor(
    private val apiDetail: APIEndpoints) :Repository {
    override suspend fun getPeopleList(): ArrayList<PeopleItemModel> {
        return apiDetail.getPeopleList()
    }

    override suspend fun getRoomList(): ArrayList<RoomItemModel> {
        return apiDetail.getRoomList()
    }
}