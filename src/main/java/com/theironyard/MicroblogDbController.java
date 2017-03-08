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
    @Autowired
    MicroblogDbRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
    model.addAttribute("messages", messages.findAll());
    model.addAttribute("editId", session.getAttribute("editId"));
    return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String messageBody){
        messages.save(new Message(messageBody));
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(HttpSession session, Integer editId){
        session.setAttribute("editId", editId);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(HttpSession session, String editedMessage){
        Integer id = (Integer)session.getAttribute("editId");
        session.removeAttribute("editId");
        Message msg = messages.findOne(id);
        msg.setText(editedMessage);
        messages.save(msg);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Integer deleteId){
        messages.delete(deleteId);
        return "redirect:/";
    }
}
