package me.aborozdykh.amazonreview.controller;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Word;
import me.aborozdykh.amazonreview.service.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Borozdykh
 */
@RestController
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/most-popular")
    public List<Word> getMostPopularWords(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") int limit) {
        return wordService.findMostPopularWords(page, limit);
    }
}
