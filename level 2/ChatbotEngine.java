// app/src/main/java/com/example/chatbot/service/ChatbotEngine.java
package com.example.chatbot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

// Chatbot engine to process user input and generate responses.
public class ChatbotEngine {
    private final Map<Pattern, String> responses; // Maps patterns to predefined responses.

    // Constructor initializing the response map.
    public ChatbotEngine() {
        responses = new HashMap<>();
        initializeResponses(); // Populates the map with patterns and responses.
    }

    // Initializes response patterns and associated replies.
    private void initializeResponses() {
        responses.put(Pattern.compile("(?i).*hello.*|.*hi.*|.*hey.*"), "Hello! How can I help you today?");
        responses.put(Pattern.compile("(?i).*how are you.*"), "I'm doing well, thank you for asking!");
        responses.put(Pattern.compile("(?i).*weather.*"), "I can't check the weather, but I can help you with general questions!");
        responses.put(Pattern.compile("(?i).*name.*"), "I'm ChatBot, nice to meet you!");
        responses.put(Pattern.compile("(?i).*bye.*|.*goodbye.*"), "Goodbye! Have a great day!");
        responses.put(Pattern.compile("(?i).*thank.*"), "You're welcome!");
    }

    // Matches input text to response patterns and returns the appropriate response.
    public String generateResponse(String input) {
        for (Map.Entry<Pattern, String> entry : responses.entrySet()) {
            if (entry.getKey().matcher(input).matches()) { // Checks if input matches a pattern.
                return entry.getValue(); // Returns corresponding response.
            }
        }
        return "I'm not sure how to respond to that. Could you rephrase your question?";
    }
}
