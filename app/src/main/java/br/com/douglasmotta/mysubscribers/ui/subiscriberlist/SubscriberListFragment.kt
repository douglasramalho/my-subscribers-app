package br.com.douglasmotta.mysubscribers.ui.subiscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import br.com.douglasmotta.mysubscribers.R
import br.com.douglasmotta.mysubscribers.data.db.AppDatabase
import br.com.douglasmotta.mysubscribers.repository.DatabaseDataSource
import br.com.douglasmotta.mysubscribers.repository.SubscriberRepository
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {

    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDao = AppDatabase.getInstance(requireContext()).subscriberDAO
                val repository: SubscriberRepository = DatabaseDataSource(subscriberDao)
                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelEvents()
    }

    private fun observeViewModelEvents() {
        viewModel.allSubscribersEvent.observe(viewLifecycleOwner) { allSubscribers ->
            val subscriberListAdapter = SubscriberListAdapter(allSubscribers)

            with(recycler_subscribers) {
                setHasFixedSize(true)
                adapter = subscriberListAdapter
            }
        }
    }
}