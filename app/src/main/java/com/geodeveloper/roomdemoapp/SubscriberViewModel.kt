package com.geodeveloper.roomdemoapp

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geodeveloper.roomdemoapp.database.Subscriber
import com.geodeveloper.roomdemoapp.database.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(),Observable {
    val subscriber = repository.subscribers
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()
    @Bindable
    val saveOrUpdate = MutableLiveData<String>()
    @Bindable
    val clearOrDelete = MutableLiveData<String>()
    init {
        saveOrUpdate.value = "Save"
        clearOrDelete.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insertSubscriber(Subscriber(0,name,email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearOrDelete(){
        clearAll()

    }
    fun insertSubscriber(subscriber: Subscriber){
        viewModelScope.launch {
            repository.insert(subscriber)
        }
    }
    fun update(subscriber: Subscriber){
        viewModelScope.launch {
            repository.update(subscriber)
        }
    }
    fun delete(subscriber: Subscriber){
        viewModelScope.launch {
            repository.delete(subscriber)
        }
    }
    fun clearAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}