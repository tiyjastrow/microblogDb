package com.theironyard;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import java.util.ArrayList;

/**
 * Created by joe on 05/10/2016.
 */

@Controller
public class MicroblogDbController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        ArrayList<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
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
