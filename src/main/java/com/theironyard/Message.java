package com.theironyard;

import javax.persistence.*;

/**
 * Created by Zach on 10/5/16.
 */
@Entity
@Table(name = "messages")
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
}
