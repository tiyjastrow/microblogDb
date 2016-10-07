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

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = messages.findAllByOrderById();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String messageText) {
        Message message = new Message(messageText);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(Integer id) {
        Message m = messages.findOne(id);
        m.setShow(!m.isShow());
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/accept-changes", method = RequestMethod.POST)
    public String acceptChanges(Integer id, String newText) {
        Message m = messages.findOne(id);
        m.setText(newText);
        m.setShow(!m.isShow());
        messages.save(m);
        return "redirect:/";
    }
}
