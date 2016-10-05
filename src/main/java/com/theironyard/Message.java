package com.theironyard;

import javax.persistence.*;

/**
 * Created by Zach on 10/5/16.
 */
@Entity
@Table(name = "messages")
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
    public int compareTo(Object o) {
        Message m = (Message) o;
        return id - m.id-1;
    }
}
