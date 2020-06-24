package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Review;

public interface ReviewService {
    Review add(Review review);

    Review get(Long id);

    void update(Review review);

    List<String> findMostUsedWordsInReview(String limit);
}
