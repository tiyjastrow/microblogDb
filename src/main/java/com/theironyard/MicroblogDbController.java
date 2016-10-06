package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremypitt on 10/5/16.
 */
@Controller
public class MicroblogDbController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path="/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path="/edit-message", method = RequestMethod.POST)
    public String editMessage(Integer editId, String editText) {
        Message editMe = messages.findOne(editId);
//        editMe.setText(editText);
        editMe.text = editText;
        messages.save(editMe);
        return "redirect:/";
    }
}
