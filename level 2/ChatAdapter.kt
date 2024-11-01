// app/src/main/java/com/example/chatbot/adapter/ChatAdapter.kt
package com.example.chatbot.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot.R
import com.example.chatbot.model.Message

// Adapter for displaying messages in a RecyclerView.
class ChatAdapter : RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {
    private val messages = mutableListOf<Message>() // List to store messages.

    // Adds a new message and updates the RecyclerView.
    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1) // Notifies that an item was added.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        // Chooses layout based on the message type (user or bot).
        val layout = if (viewType == 0) R.layout.item_message_user else R.layout.item_message_bot
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MessageViewHolder(view) // Returns a new ViewHolder instance.
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position]) // Binds message data to the ViewHolder.
    }

    override fun getItemCount() = messages.size // Returns number of messages.

    // Determines the type of message for layout selection.
    override fun getItemViewType(position: Int) = if (messages[position].isBot) 1 else 0

    // ViewHolder class to manage individual message views.
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageText: TextView = view.findViewById(R.id.messageText)

        // Binds message data to TextView.
        fun bind(message: Message) {
            messageText.text = message.text
        }
    }
}
