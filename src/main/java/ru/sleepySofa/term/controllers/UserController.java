package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.enums.Role;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.services.LectureService;
import ru.sleepySofa.term.services.UserService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashSet;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LectureService lectureService;
    @GetMapping("/login")
    public String login() {
        return "utility/loginForm";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        return "utility/regist";
    }

    @PostMapping("/register")
    public String saveUser(Account user, Model model) {
        if (!userService.createAccount(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "utility/regist";
        }
        return "redirect:/login";
    }

    @GetMapping("/me")
    public String me(Model model,Principal principal) {
        Account user = userService.getUserByPrinciple(principal);
        model.addAttribute("user", user);
        if (user.getRoles().contains(Role.ROLE_TEACHER)) {
            model.addAttribute("lectures", lectureService.getLecturesByAuthor(user));
        }
        return "/users/user";
    }

}
