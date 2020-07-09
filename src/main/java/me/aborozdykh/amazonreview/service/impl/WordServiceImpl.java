package me.aborozdykh.amazonreview.service.impl;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Word;
import me.aborozdykh.amazonreview.repository.WordRepository;
import me.aborozdykh.amazonreview.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> saveAll(List<Word> words) {
        return wordRepository.saveAll(words);
    }

    @Override
    public List<Word> findMostPopularWords(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return wordRepository.findMostPopularWords(pageable).toList();
    }
}
