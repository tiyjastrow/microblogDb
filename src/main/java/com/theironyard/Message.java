package com.theironyard;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message implements Comparable {
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
    @Override
    public int compareTo(Object O) {
        Message m = (Message) O;
        return id - m.id;
    }

}
