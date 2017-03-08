package com.theironyard;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
