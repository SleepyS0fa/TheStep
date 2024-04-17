package ru.sleepySofa.term.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.sleepySofa.term.converters.MultiValueMapToLectureConverter;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.services.GroupService;
import ru.sleepySofa.term.services.LectureService;
import ru.sleepySofa.term.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class LectureController {

    @Autowired
    private final GroupService groupService;
    @Autowired
    private final LectureService lectureService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final MultiValueMapToLectureConverter lectureConverter;
    @GetMapping("/lecture")
    public String infoLecture(@RequestParam(name = "search", required = false) String search, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrinciple(principal));
        model.addAttribute("lectures", lectureService.searchLecture(userService.getUserByPrinciple(principal), search));
        return "lecture/lecture-main";
    }

    @GetMapping("/lecture/{id}")
    public String infoLecture(@PathVariable Long id, Model model, Principal principal) {
        if (lectureService.getLectureById(id) == null)
            return "errors/error-404";
        model.addAttribute("user", userService.getUserByPrinciple(principal));
        model.addAttribute("lecture", lectureService.getLectureById(id));
        return "lecture/lecture-text";
    }

    @GetMapping("/lecture/create")
    public String formLecture(Model model){
        model.addAttribute("groups", groupService.getGroups());
        return "lecture/lecture-create-form";
    }

    @PostMapping("/lecture/create")
    public String createLecture(@RequestParam MultiValueMap<String, Object> map, Principal principal){

        Lecture lecture = lectureConverter.convert(map);
//        if (lecture == null) {
//            // временная заглушка, отправить ошибку некоректных данных
//            return "errors/error-404";
//        }
        if (lecture.getText() == null) {
            System.out.println("Text lecture is null. Redirecting..");
            return "redirect:/lecture/create";
        }
        if (lecture.getGroups() == null) {
            lecture.setGroups(groupService.getGroups());
        }
        lecture.setAuthor(userService.getUserByPrinciple(principal));
        lectureService.saveLecture(lecture);
        return "redirect:/lecture";
    }

    @PostMapping("/lecture/delete/{id}")
    public String delete(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return "redirect:/lecture";
    }
    @PostMapping("/me/lecture/delete")
    public String deleteFromTeacher(@RequestParam Long id) {
        lectureService.deleteLecture(id);
        return "redirect:/me";
    }
}
