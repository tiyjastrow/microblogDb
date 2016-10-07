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

    @Column(nullable = false)
    boolean show = true;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isShow() {
        return show;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
