package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.services.LectureService;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final LectureService lectureService;
    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("lectures", lectureService.listAll());
        return "mainPage";
    }
}

