package com.theironyard;

import javax.persistence.*;

@Entity
@Table (name="messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
