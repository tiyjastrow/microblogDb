package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MicroblogDbController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model){
        List<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }
    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String postMessage(String message){
        Message newMessage = new Message(message);
        messages.save(newMessage);
        return "redirect:/";
    }
    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(int messageId, String editMessage){
        Message m = messages.findOne(messageId);
//        System.out.println(messageId);
//        System.out.println(editMessage);
        m.message = editMessage;
        messages.save(m);
        return "redirect:/";
    }
}
