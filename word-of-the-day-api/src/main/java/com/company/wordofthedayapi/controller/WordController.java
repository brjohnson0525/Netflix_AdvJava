package com.company.wordofthedayapi.controller;

import com.company.wordofthedayapi.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WordController {

    private List<Word> wordList;
    private static int idCounter = 1;

    public WordController() {
        wordList = new ArrayList<>();

        wordList.add(new Word(idCounter++, "class", "a set or category of things having some property or attribute in common and differentiated from others by kind, type, or quality."));
        wordList.add(new Word(idCounter++, "entity", "a thing with distinct and independent existence"));
        wordList.add(new Word(idCounter++, "input", "what is put in, taken in, or operated on by any process or system"));
        wordList.add(new Word(idCounter++, "add", "join (something) to something else so as to increase the size, number, or amount"));
        wordList.add(new Word(idCounter++, "value", "the regard that something is held to deserve; the importance, worth, or usefulness of something"));
        wordList.add(new Word(idCounter++, "static", "lacking in movement action, or change, especially in a way viewed as undesirable or uninteresting"));
        wordList.add(new Word(idCounter++, "status", "the relative social, professional, or other standing of someone or something"));
        wordList.add(new Word(idCounter++, "array", "an impressive display or range of a particular type of thing"));
        wordList.add(new Word(idCounter++, "request", "an act of asking politely or formally for something"));
        wordList.add(new Word(idCounter++, "response", "a verbal or written answer"));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Word> getAllWords(@RequestParam(required = false) String word) {
       List<Word> returnList = wordList;

       if (word !=null) {
           returnList = wordList.stream()
                   .filter(r -> r.getWord().contains(word))
                   .collect(Collectors.toList());
       }

       return returnList;
    }
}
