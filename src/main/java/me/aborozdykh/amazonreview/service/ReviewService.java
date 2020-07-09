package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Review;

public interface ReviewService {
    Review save(Review review);

    List<Review> saveAll(List<Review> reviews);

    Review get(Long id);

    List<String> findMostUsedWordsInReview(Long limit);
}
