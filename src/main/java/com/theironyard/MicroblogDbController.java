package com.theironyard;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by EdHall on 10/4/16.
 */
@Controller
public class MicroblogDbController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("username"));
        List<Message> messages = (List<Message>) messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username) {
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
    public String add(String text) {
        if(! text.isEmpty()) {
            messageRepository.save(new Message(text));
        }

        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String edit(String text, Integer id) {
        if(! text.isEmpty()) {
            messageRepository.delete(id);
            messageRepository.save(new Message(text));
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(Integer id) {
        messageRepository.delete(id);
        return "redirect:/";
    }
}