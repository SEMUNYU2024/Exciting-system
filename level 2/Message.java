// app/src/main/java/com/example/chatbot/model/Message.java
package com.example.chatbot.model;

// Model class to represent a chat message.
public class Message {
    private final String text; // Text content of the message.
    private final boolean isBot; // Flag to indicate if the message is from the bot.
    private final long timestamp; // Timestamp when the message is created.

    // Constructor to initialize message text and sender.
    public Message(String text, boolean isBot) {
        this.text = text;
        this.isBot = isBot;
        this.timestamp = System.currentTimeMillis(); // Sets timestamp to current time.
    }

    // Getter for the message text.
    public String getText() { return text; }
    // Getter for the sender flag.
    public boolean isBot() { return isBot; }
    // Getter for the timestamp.
    public long getTimestamp() { return timestamp; }
}
