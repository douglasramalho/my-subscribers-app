package br.com.douglasmotta.mysubscribers.ui.subscriberlist

import androidx.lifecycle.ViewModel
import br.com.douglasmotta.mysubscribers.repository.SubscriberRepository

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    val allSubscribersEvent = repository.getAllSubscribers()
}