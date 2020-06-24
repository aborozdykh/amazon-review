package me.aborozdykh.amazonreview.service.impl;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Review;
import me.aborozdykh.amazonreview.repository.ReviewRepository;
import me.aborozdykh.amazonreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review get(Long id) {
        return reviewRepository.getOne(id);
    }

    @Override
    public List<String> findMostUsedWordsInReview(String limit) {
        return null;
    }
}
