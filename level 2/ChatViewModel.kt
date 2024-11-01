// app/src/main/java/com/example/chatbot/viewmodel/ChatViewModel.kt
package com.example.chatbot.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.model.Message
import com.example.chatbot.service.ChatbotEngine
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// ViewModel for managing chat messages and interaction with ChatbotEngine.
class ChatViewModel : ViewModel() {
    private val chatbotEngine = ChatbotEngine() // Instance of ChatbotEngine.
    private val _messages = MutableLiveData<Message>() // Holds messages.
    val messages: LiveData<Message> = _messages // Exposes messages as LiveData.

    // Processes user message and generates a bot response.
    fun sendMessage(text: String) {
        _messages.value = Message(text, false) // Adds user message.

        // Launches a coroutine to generate a bot response with a delay.
        viewModelScope.launch {
            delay(500) // Adds delay to simulate processing.
            val response = chatbotEngine.generateResponse(text)
            _messages.value = Message(response, true) // Adds bot response.
        }
    }
}
