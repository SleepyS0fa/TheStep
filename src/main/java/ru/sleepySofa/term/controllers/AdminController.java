package ru.sleepySofa.term.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.services.GroupService;
@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    @Autowired
    GroupService groupService;
    @GetMapping("/admin")
    public String adminPanel(){
        return "administrator";
    }
    @PostMapping("/create/group/")
    public String createGroup(Group group) {
        groupService.saveGroup(group);
        return "redirect:/admin";
    }
    @PostMapping("/create/client/")
    public String createGroup(Account client) {
        return "redirect:/admin";
    }
}
