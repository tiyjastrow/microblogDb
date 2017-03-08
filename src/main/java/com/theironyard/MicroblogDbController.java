package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import java.util.List;


@Controller
public class MicroblogDbController {
    private static String loggedInUser = "loggedInUser";
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(int id, String text) {
        Message msg = new Message(id, text);
        messages.save(msg);//ToDo check this...
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String edit(Model model, int id) {
        Message msg = messages.findOne(id);
        model.addAttribute("messages", msg);
        return "edit";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String add(String text) {
        Message msg = new Message(text);
        messages.save(msg);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(int id) {
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute(loggedInUser));
        List<Message> msgList = (List<Message>) messages.findAll();
        model.addAttribute("messages", msgList);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute(loggedInUser, userName);
        return "redirect:/";
    }

}
