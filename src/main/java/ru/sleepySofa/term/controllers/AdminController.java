package ru.sleepySofa.term.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.enums.Role;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.services.GroupService;
import ru.sleepySofa.term.services.LectureService;
import ru.sleepySofa.term.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    @Autowired
    LectureService lectureService;
    @GetMapping("/admin")
    public String adminPanel(Model model, Principal principal){
        model.addAttribute("user", userService.getUserByPrinciple(principal));
        model.addAttribute("users", userService.listAll());
        return "users/administrator";
    }
//    TODO управление пользователями
    @GetMapping("/admin/user/{id}")
    public String changeUser(@PathVariable Long id , Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "utility/userInterface";
    }

    @PostMapping("/admin/user/{id}/addRole")
    public String addRole(Model model, @PathVariable Long id,@RequestParam List<String> roles) {
        Account user = userService.getUserById(id);
        for(String role : roles) {
            user.getRoles().add(Role.valueOf(role));
        }
        userService.saveAccount(user);
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "utility/userInterface";
    }

    @PostMapping("/admin/user/{id}/changePassword")
    public String changePass(Model model, @PathVariable Long id,@RequestParam String password) {
        Account user = userService.getUserById(id);
        userService.changePass(user, password);
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "utility/userInterface";
    }

    @PostMapping("/admin/user/{id}/changeEmail")
    public String changeEmail(Model model, @PathVariable Long id,@RequestParam String email) {
        Account user = userService.getUserById(id);
        userService.changeEmail(user, email);
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        return "utility/userInterface";
    }
    @PostMapping("/admin/create/group/")
    public String createGroup(Group group) {
        groupService.saveGroup(group);
        return "redirect:/admin";
    }
    @PostMapping("/admin/create/client/")
    public String createGroup(Account client) {
        return "redirect:/admin/panel";
    }

    @PostMapping("admin/lecture/delete/{id}")
    public String deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return "redirect:/lecture";
    }
}
