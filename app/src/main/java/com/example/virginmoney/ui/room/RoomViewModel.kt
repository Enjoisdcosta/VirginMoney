package com.example.virginmoney.ui.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.room.RoomItemModel
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {

    //    private val _peopleList = MutableLiveData<ArrayList<PeopleItemModel>>()
//    val peopleList: LiveData<ArrayList<PeopleItemModel>> = _peopleList
    private val _roomList = MutableLiveData<ArrayList<RoomItemModel>>()

    val roomList: LiveData<ArrayList<RoomItemModel>> = _roomList

    init {
        getRoomList()
    }

    fun getRoomList() {
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getRoomList()

            if (!result.isNullOrEmpty()) {
                _roomList.postValue(result)
            }

        }
    }
}

