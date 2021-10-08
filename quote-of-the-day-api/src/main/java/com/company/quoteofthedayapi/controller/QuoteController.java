package com.company.quoteofthedayapi.controller;

import com.company.quoteofthedayapi.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuoteController {

    private List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "A life is not important except in the impact it has on other lives.","Jackie Robinson"));
        quoteList.add(new Quote(idCounter++, "If you don't like something, change it. If you can't change it, change your attitude.","Maya Angelou"));
        quoteList.add(new Quote(idCounter++, "All of our dreams can come true, if we have the courage to pursue them.","Walt Disney"));
        quoteList.add(new Quote(idCounter++, "You only live once, but if you do it right, once is enough.","Mae West"));
        quoteList.add(new Quote(idCounter++, "Life is short, and it is up to you to make it sweet.","Sarah Louise Delany"));
        quoteList.add(new Quote(idCounter++, "The journey of a thousand miles begins with one step.","Lao Tzu"));
        quoteList.add(new Quote(idCounter++, "Things turn out best for the people who make the best of the way things turn out.","John Wooden"));
        quoteList.add(new Quote(idCounter++, "The secret of getting ahead is getting started.","Mark Twain"));
        quoteList.add(new Quote(idCounter++, "It does not matter how slowly you go as long as you do not stop.","Confucius"));
        quoteList.add(new Quote(idCounter++, "Life is too important to be taken seriously.","Oscar Wilde"));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Quote> getAllQuotes(@RequestParam(required = false) String quote) {
        List<Quote> returnList = quoteList;

        if (quote !=null) {
            returnList = quoteList.stream()
                    .filter(r -> r.getQuote().contains(quote))
                    .collect(Collectors.toList());
        }

        return returnList;
    }
}
