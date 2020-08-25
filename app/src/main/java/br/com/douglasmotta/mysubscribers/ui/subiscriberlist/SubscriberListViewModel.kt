package br.com.douglasmotta.mysubscribers.ui.subiscriberlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.mysubscribers.data.db.entity.SubscriberEntity
import br.com.douglasmotta.mysubscribers.repository.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    private val _allSubscribersEvent = MutableLiveData<List<SubscriberEntity>>()
    val allSubscribersEvent: LiveData<List<SubscriberEntity>>
        get() = _allSubscribersEvent

    private val _deleteAllSubscribersEvent = MutableLiveData<Unit>()
    val deleteAllSubscribersEvent: LiveData<Unit>
        get() = _deleteAllSubscribersEvent

    fun getSubscribers() = viewModelScope.launch {
        _allSubscribersEvent.postValue(repository.getAllSubscribers())
    }

    fun deleteAllSubscribers() = viewModelScope.launch {
        try {
            repository.deleteAllSubscribers()
            _deleteAllSubscribersEvent.postValue(Unit)
        } catch (ex: Exception) {
            Log.e(TAG, ex.toString())
        }
    }

    companion object {
        private val TAG = SubscriberListViewModel::class.java.simpleName
    }
}