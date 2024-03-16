package com.example.demorandomuserapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demorandomuserapi.api.RandomUserAPI
import com.example.demorandomuserapi.model.RandomUserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RandomUserRepository @Inject constructor(private val randomUserAPI: RandomUserAPI){

    private val _getRandomUserData= MutableStateFlow<RandomUserData?>(null)

    val getRandomUserData: StateFlow<RandomUserData?> get()=_getRandomUserData

    suspend fun getRandomUserData(result:Int){
        val data=randomUserAPI.getRandomUserData(result)
        if(data.isSuccessful&&data.body()!=null){
            _getRandomUserData.emit(data.body())
        }
    }

    private val _getRandomUserLiveData= MutableLiveData<RandomUserData?>(null)

    val getRandomUserLiveData: LiveData<RandomUserData?> get()=_getRandomUserLiveData

    suspend fun getRandomUserLiveData(result:Int){
        val data=randomUserAPI.getRandomUserData(result)
        if(data.isSuccessful&&data.body()!=null){
            _getRandomUserLiveData.postValue(data.body())
        }
    }
}