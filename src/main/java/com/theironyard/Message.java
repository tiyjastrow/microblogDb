package com.theironyard;

import org.omg.CORBA.Object;

import javax.persistence.*;

@Entity
@Table (name="messages")
public class Message implements Comparable {
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

    @Override
    public int compareTo(java.lang.Object o) {
        Message m = (Message) o;
        return id - m.id;

    }
}
