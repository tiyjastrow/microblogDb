package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class MicroDbController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        List<Message> messageList = (ArrayList) messages.findAll();
        Collections.sort(messageList);
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "add-message", method = RequestMethod.POST)
    public String addMessage(String messageText) {
        Message message = new Message(messageText);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "edit-message", method = RequestMethod.POST)
    public String editMessage(String editText, String oldText, int id){
        Message m = messages.findOne(id);
        m.text = editText;
        messages.save(m);
        return "redirect:/";
    }

}
