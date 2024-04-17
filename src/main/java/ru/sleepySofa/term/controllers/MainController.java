package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.repositories.LectureRepository;
import ru.sleepySofa.term.repositories.UserRepository;
import ru.sleepySofa.term.services.LectureService;
import ru.sleepySofa.term.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private UserService userService;

    private final LectureService lectureService;
    @GetMapping("/")
    public String mainPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrinciple(principal));
        return "mainPage";
    }
}

