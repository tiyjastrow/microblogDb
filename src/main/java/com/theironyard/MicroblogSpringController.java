package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MicroblogSpringController {
    @Autowired
    MessageRepository messages;
    //static ArrayList<Message> messages = new ArrayList<>();
    //static int counter = 0;

    @RequestMapping(path="/", method= RequestMethod.GET)
    public String home(Model model, HttpSession session){

        List<Message> messageList = (List<Message>)messages.findAll();
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path="/edit", method=RequestMethod.GET)
    public String home(Model model, Integer id, String message){
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        return("edit");

    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(HttpSession session, String userName){
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path="/add-message", method=RequestMethod.POST)
    public String addMessage(String message){
        Message m = new Message(message);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path="/delete-message", method=RequestMethod.POST)
    public String deleteMessage(int id){
        //messages.removeIf(message-> id == message.id);
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path="/edit-message", method=RequestMethod.POST)
    public String editMessage(String message, Integer id){
        messages.save(new Message(id, message));
        return "redirect:/";
    }

}
