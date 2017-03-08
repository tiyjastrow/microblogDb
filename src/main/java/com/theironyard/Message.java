package com.theironyard;


import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    Integer id;
    @Column
    String text;

    public Message() {
    }


    public Message(String text) {
        this.text = text;
    }
}
