package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Word;

public interface WordService {
    List<Word> saveAll(List<Word> words);

    List<Word> findMostPopularWords(int page, int limit);
}
