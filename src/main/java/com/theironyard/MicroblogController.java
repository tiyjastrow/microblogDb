package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MicroblogController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("messages", messages.findAll());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username) {
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
        messages.save(new Message(text));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id) {
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.GET)
    public String getEdit(Model model, int id) {
        model.addAttribute("message", messages.findOne(id));
        return "edit-message";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String text) {
        messages.save(new Message(id, text));
        return "redirect:/";
    }
}
