package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.Term;
import ru.sleepySofa.term.repositories.TermRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TermService {

    @Autowired
    TermRepository termRepository;

    public boolean saveTerm(Term term) {
        try {
            termRepository.save(term);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean saveTerms(List<Term> terms) {
        try {
            for(Term term: terms) {
                termRepository.save(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
