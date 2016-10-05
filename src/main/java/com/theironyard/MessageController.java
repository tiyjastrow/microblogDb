package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zach on 10/5/16.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        ArrayList<Message> messageList = (ArrayList) messages.findAll();
        Collections.sort(messageList);
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message newMessage = new Message(text);
        messages.save(newMessage);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String goToEdit(Model model, Integer id) {
        List<Message> messageList = (ArrayList) messages.findAll();
        Message msg = new Message();
        for (Message m : messageList) {
            if (m.id == id) {
                msg = m;
            }
        }

        model.addAttribute("message", msg);
        return "edit";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(Integer id, String editText) {
        Message messageToEdit = messages.findOne(id);
        messageToEdit.text = editText;
        messages.save(messageToEdit);
        return "redirect:/";
    }

}
