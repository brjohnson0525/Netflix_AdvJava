package com.company.wordofthedayapi.model;

import java.util.Objects;

public class Word {

    //Properties
    private int id;
    private String word;
    private String definition;

    //Constructor
    public Word() {  }

    //Constructor
    public Word(int id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    //Equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return id == word1.id && Objects.equals(word, word1.word) && Objects.equals(definition, word1.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, definition);
    }
}
