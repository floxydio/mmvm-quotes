package com.floxy.crudnative.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.floxy.crudnative.models.QuotesModel
import com.floxy.crudnative.networks.QuotesNetwork
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {
    val myResponse: MutableLiveData<List<QuotesModel>> = MutableLiveData()

    fun fetchQuotes() {
        viewModelScope.launch {
            myResponse.value = QuotesNetwork.retrofit.getQuotes()
        }
    }

}