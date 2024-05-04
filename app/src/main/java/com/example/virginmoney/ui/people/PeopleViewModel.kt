package com.example.virginmoney.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.people.PeopleItemModel
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    //    private val _peopleList = MutableLiveData<ArrayList<PeopleItemModel>>()
//    val peopleList: LiveData<ArrayList<PeopleItemModel>> = _peopleList
    private val _peopleList = MutableLiveData<ArrayList<PeopleItemModel>>()

    val peopleList: LiveData<ArrayList<PeopleItemModel>> = _peopleList

    init {
        getPeopleList()
    }

    fun getPeopleList() {
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getPeopleList()

            if (!result.isNullOrEmpty()) {
                _peopleList.postValue(result)
            }

        }
    }
}

