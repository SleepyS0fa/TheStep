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
public class LectureController {
    private final LectureService lectureService;
    @GetMapping("/lecture/{id}")
    public String infoLecture(@PathVariable Long id, Model model) {
        if (lectureService.getLectureById(id) == null)
            return "errors/error-404";
        model.addAttribute("lecture", lectureService.getLectureById(id));
        return "lecture-text";
    }

    @GetMapping("/lecture/create")
    public String formLecture(Model model){
        model.addAttribute("groups", lectureService.getGroups());
        return "lecture-create-form";
    }

    @PostMapping("/lecture/create")
    public String createLecture(Lecture lecture){
        lectureService.saveLecture(lecture);
        return "redirect:/";
    }

    @PostMapping("lecture/delete/{id}")
    public String deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return "redirect:/";
    }
}
