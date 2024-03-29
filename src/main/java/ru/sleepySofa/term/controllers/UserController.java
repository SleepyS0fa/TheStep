package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String auth(Model model) {
        return "loginForm";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "regist";
    }

    @PostMapping("/registration")
    public String saveUser(Account user, Model model) {
        userService.addRoleAdmin(user);

        if (userService.createAccount(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "regist";
        }
        return "redirect:/login";
    }

}
