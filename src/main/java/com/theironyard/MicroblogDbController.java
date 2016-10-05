package com.theironyard;

import org.hibernate.Hibernate;
import org.hibernate.annotations.OrderBy;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by joe on 05/10/2016.
 */

@Controller
public class MicroblogDbController{

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List) messages.findAll();
        Collections.sort(messageList);
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(Model model, String text) {

        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String text) {

        Message m = messages.findOne(id);
        m.text = text;
        messages.save(m);
        return "redirect:/";
    }
}
