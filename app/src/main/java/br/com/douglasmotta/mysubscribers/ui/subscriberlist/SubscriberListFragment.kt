package br.com.douglasmotta.mysubscribers.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.douglasmotta.mysubscribers.R
import br.com.douglasmotta.mysubscribers.data.db.entity.SubscriberEntity
import br.com.douglasmotta.mysubscribers.ui.subiscriberlist.SubscriberListAdapter
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {

    private lateinit var viewModel: SubscriberListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subscriberListAdapter = SubscriberListAdapter(
            listOf(
                SubscriberEntity(1, "Douglas", "douglas@douglas.com"),
                SubscriberEntity(2, "Diogo", "diogo@diogo.com")
            )
        )

        with(recycler_subscribers) {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }
    }
}