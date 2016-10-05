package com.theironyard;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String text;


    public Message() {
    }

    public Message(Integer id, String text){
        this.id = id;
        this.text = text;
    }

    public Message(String text) {
        this.text = text;
    }
}
