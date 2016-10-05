package com.theironyard;

import javax.persistence.*;
import javax.persistence.metamodel.ListAttribute;

@Entity
@Table(name = "messages")
public class Message implements Comparable{
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;


    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    @Override
    public int compareTo(Object o) {
        Message m = (Message) o;
        return id - m.id;
    }
}
