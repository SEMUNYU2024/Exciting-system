// MainActivity.kt
package com.example.chatbot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot.adapter.ChatAdapter
import com.example.chatbot.databinding.ActivityMainBinding
import com.example.chatbot.viewmodel.ChatViewModel

// Main activity for the chat application.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // View binding for layout access.
    private val viewModel: ChatViewModel by viewModels() // ViewModel instance.
    private val chatAdapter = ChatAdapter() // Adapter for managing chat messages.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initializes view binding.
        setContentView(binding.root)

        setupRecyclerView() // Sets up the RecyclerView.
        setupMessageInput() // Configures message input handling.
        observeMessages() // Observes message updates from ViewModel.
    }

    private fun setupRecyclerView() {
        binding.chatRecyclerView.apply {
            layoutManager = LinearLayoutManager(context) // Sets layout manager.
            adapter = chatAdapter // Binds adapter to RecyclerView.
        }
    }

    private fun setupMessageInput() {
        // Sets up click listener for the send button.
        binding.sendButton.setOnClickListener {
            val message = binding.messageInput.text.toString().trim()
            if (message.isNotEmpty()) {
                viewModel.sendMessage(message) // Sends message to ViewModel.
                binding.messageInput.text?.clear() // Clears input field.
            }
        }
    }

    private fun observeMessages() {
        // Observes messages and updates the adapter when they change.
        viewModel.messages.observe(this) { message ->
            chatAdapter.addMessage(message) // Adds message to adapter.
            binding.chatRecyclerView.smoothScrollToPosition(chatAdapter.itemCount - 1) // Scrolls to latest message.
        }
    }
}
