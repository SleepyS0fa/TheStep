package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.repositories.LectureRepository;
import ru.sleepySofa.term.services.LectureService;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final LectureService lectureService;
    @GetMapping("/")
    public String mainPage(Model model) {
        return "mainPage";
    }
}

