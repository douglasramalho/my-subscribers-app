package br.com.douglasmotta.mysubscribers.repository

import androidx.lifecycle.LiveData
import br.com.douglasmotta.mysubscribers.data.db.entity.SubscriberEntity

interface SubscriberRepository {
    suspend fun insertSubscriber(name: String, email: String): Long

    suspend fun updateSubscriber(id: Long, name: String, email: String)

    suspend fun deleteSubscriber(id: Long)

    suspend fun deleteAllSubscribers()

    fun getAllSubscribers(): LiveData<List<SubscriberEntity>>
}