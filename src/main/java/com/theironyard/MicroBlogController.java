package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MicroBlogController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("messages", messageList);

        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String newMessage) {
        Message message = new Message(newMessage);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(String editMessage, Integer editid) {
        Message  message = messages.findOne(editid);
        message.text = editMessage;
        messages.save(message);
        return "redirect:/";
    }

}
