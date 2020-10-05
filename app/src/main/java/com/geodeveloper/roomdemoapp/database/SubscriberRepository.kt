package com.geodeveloper.roomdemoapp.database

class SubscriberRepository(private val dao: SubscriberDAO) {
    val subscribers = dao.getAllSubscriber()

    suspend fun inser(subscriber: Subscriber){
        dao.inserSubscriber(subscriber)
    }
    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }
    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}