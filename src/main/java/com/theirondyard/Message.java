package com.theirondyard;
import javax.persistence.*;
/**
 * Created by joshuakeough on 10/5/16.
 */
@Entity
@Table(name = "messages")
public class Message implements Comparable{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(Object o) {
        Message m = (Message) o;
        return id - m.getId();
    }
}
