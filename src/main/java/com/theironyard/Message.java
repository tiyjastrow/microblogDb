package com.theironyard;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message(String text) {this.text = text;}

    public Message(int id) {this.id = id;}

    public Message(int id, String text) {
        this.text = text;
        this.id = id;
    }


    public Message() {
    }
}