package com.example.demorandomuserapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demorandomuserapi.model.RandomUserData
import com.example.demorandomuserapi.repository.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(private val randomUserRepository: RandomUserRepository) :ViewModel() {

    val randomUserData: StateFlow<RandomUserData?> get() =randomUserRepository.getRandomUserData

    suspend fun getRandomUserData(result:Int){
        viewModelScope.launch {
            randomUserRepository.getRandomUserData(result)
        }
    }

    val randomUserLiveData: LiveData<RandomUserData?> get() =randomUserRepository.getRandomUserLiveData

    suspend fun getRandomUserLiveData(result:Int){
        viewModelScope.launch {
            randomUserRepository.getRandomUserLiveData(result)
        }
    }
}