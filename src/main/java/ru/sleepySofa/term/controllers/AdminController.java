package ru.sleepySofa.term.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.User;
import ru.sleepySofa.term.services.GroupService;
@Controller
public class AdminController {
    @Autowired
    GroupService groupService;
    @GetMapping("/admin")
    public String formLecture(){
        return "administrator";
    }
    @PostMapping("/create/group/")
    public String createGroup(Group group) {
        groupService.saveGroup(group);
        return "redirect:/admin";
    }
    @PostMapping("/create/user/")
    public String createGroup(User user) {
        return "redirect:/admin";
    }
}
