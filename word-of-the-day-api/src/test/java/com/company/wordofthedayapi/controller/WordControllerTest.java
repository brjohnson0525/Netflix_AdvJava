package com.company.wordofthedayapi.controller;

import com.company.wordofthedayapi.model.Word;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Word> wordList;

    @Before
    public void setUp() throws Exception {

    }

    //GET uri/quote
    @Test
    public void returnAllWordsInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(wordList);

        mockMvc.perform(get("/quotes"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
