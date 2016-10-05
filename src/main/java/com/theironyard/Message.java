package com.theironyard;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
