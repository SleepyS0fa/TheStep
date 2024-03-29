package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.services.GroupService;
import ru.sleepySofa.term.services.LectureService;
import ru.sleepySofa.term.services.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LectureController {

    @Autowired
    private final GroupService groupService;
    @Autowired
    private final LectureService lectureService;
    @GetMapping("/lecture")
    public String infoLecture(@RequestParam(name = "search", required = false) String search, Model model) {

        model.addAttribute("lectures", lectureService.searchLecture(search));
        return "lecture-main";
    }

    @GetMapping("/lecture/{id}")
    public String infoLecture(@PathVariable Long id, Model model) {
        if (lectureService.getLectureById(id) == null)
            return "errors/error-404";
        model.addAttribute("lecture", lectureService.getLectureById(id));
        return "lecture-text";
    }

    @GetMapping("/lecture/create")
    public String formLecture(Model model){
        model.addAttribute("groups", groupService.getGroups());
        return "lecture-create-form";
    }

    @PostMapping("/lecture/create")
    public String createLecture(Lecture lecture){
        if (lecture.getText() == null) {
            return "redirect:/lecture/create";
        }
        if (lecture.getGroups() == null) {
            lecture.setGroups(groupService.getGroups());
        }
        lectureService.saveLecture(lecture);
        return "redirect:/lecture";
    }

    @PostMapping("lecture/delete/{id}")
    public String deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return "redirect:/lecture";
    }
}
