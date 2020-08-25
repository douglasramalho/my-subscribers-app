package br.com.douglasmotta.mysubscribers.ui.subiscriberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.douglasmotta.mysubscribers.R
import br.com.douglasmotta.mysubscribers.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_item.view.*

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>,
    private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
) : RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subscriber_item, parent, false)

        return SubscriberListViewHolder(view, onSubscriberClickListener)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }

    override fun getItemCount(): Int = subscribers.size

    class SubscriberListViewHolder(
        itemView: View,
        private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val textViewSubscriberName: TextView = itemView.text_subscriber_name
        private val textViewSubscriberEmail: TextView = itemView.text_subscriber_email

        fun bindView(subscriber: SubscriberEntity) {
            textViewSubscriberName.text = subscriber.name
            textViewSubscriberEmail.text = subscriber.email

            itemView.setOnClickListener {
                onSubscriberClickListener.invoke(subscriber)
            }
        }
    }
}