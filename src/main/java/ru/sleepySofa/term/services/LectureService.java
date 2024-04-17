package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.models.Term;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.repositories.LectureRepository;
import ru.sleepySofa.term.repositories.TermRepository;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureService {
    @Autowired
    private final LectureRepository lectureRepository;
    @Autowired
    private final TermService termService;

    public List<Lecture> listAll() {
        return (List<Lecture>) lectureRepository.findAll();
    }


    public boolean saveLecture(Lecture lecture) {
        log.info("Saving new {}", lecture);
        termService.saveTerms(lecture.getTerms());
        lectureRepository.save(deleteSpaceInTerms(replaceTermInText(lecture)));
        return true;
    }

    public Lecture deleteSpaceInTerms(Lecture lecture) {
        List<Term> listTerm = lecture.getTerms();
        for (Term term : listTerm) {
            term.setTerm(term.getTerm().replace(" ", ""));
        }
        lecture.setTerms(listTerm);
        return lecture;
    }


    public Lecture replaceTermInText(Lecture lecture) {
        StringBuilder lectureTextBuilder =  new StringBuilder(lecture.getText());
        //костыль счетчик
        int i = -1;
        for (Term term : lecture.getTerms()) {
            i++;
            String termText = term.getTerm();
            if (termText.length() >= 5) {
                termText = termText.substring(0, termText.length() - 2);
            }
            if (termText.length() <= 4 && termText.length() > 1) {
                termText = termText.substring(0, termText.length() - 1);
            }
            lecture.getTerms().get(i).setTerm(termText);
            Pattern pattern =  Pattern.compile(String.format("(?=\\s?[^>'\"])\\b%s[\\w]+\\b(?=[^<'\"])", termText),
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE | Pattern.MULTILINE);
            Matcher matcher =pattern.matcher(lectureTextBuilder);
            while (matcher.find()) {
                String usedTermForm = lectureTextBuilder.substring(matcher.start(), matcher.end());
                termText = termText.replace(" ", "");

                lectureTextBuilder.replace(
                        matcher.start(),
                        matcher.end(),
                        String.format("<a tabindex='0' role='button' for='%s' class='font-italic' data-toggle='popover'>%s</a>", termText, usedTermForm)
                );
                matcher = pattern.matcher(lectureTextBuilder);
            }
        }
        lecture.setText(lectureTextBuilder.toString());
        return lecture;
    }

    public boolean deleteLecture(Long id) {
        log.info("Deleting {}", id);
        lectureRepository.deleteById(id);
        return true;
    }

    public List<Lecture> getLecturesByAuthor(Account author) {
        log.info("Getting by author {}", author.getUsername());
        List<Lecture> lectures = lectureRepository.findByAuthor(author);
        if (!lectures.isEmpty())
            return lectures;
        return null;
    }

    public List<Lecture> getLecturesByTitle(String title) {
        log.info("Getting by title {}", title);
        List<Lecture> lectures = lectureRepository.findByTitle(title);
        if (!lectures.isEmpty())
            return lectures;
        return null;
    }

    public Lecture getLectureById(Long id) {
        log.info("Getting by id {}", id);
        return lectureRepository.findById(id).orElse(null);
    }

    public List<Lecture> searchLecture(Account search, String title) {
        List<Lecture> filteredLectures = new ArrayList<>();
        if (getLecturesByAuthor(search) != null)
            filteredLectures.addAll(getLecturesByAuthor(search));
        if (getLecturesByTitle(title) != null)
            filteredLectures.addAll(getLecturesByTitle(title));

        if (!filteredLectures.isEmpty())
            return filteredLectures;
        else
            return listAll();
    }

}
