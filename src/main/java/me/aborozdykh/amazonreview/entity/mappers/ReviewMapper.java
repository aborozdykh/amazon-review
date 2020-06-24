package me.aborozdykh.amazonreview.entity.mappers;

import me.aborozdykh.amazonreview.entity.Review;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.service.ProductService;
import me.aborozdykh.amazonreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Andrii Borozdykh
 */
public class ReviewMapper {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public Review getReviewFromReviewRequestDto(ReviewRequestDto reviewRequestDto){
        var review = new Review();
        review.setId(reviewRequestDto.getId());
        review.setHelpfulnessDenominator(reviewRequestDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(reviewRequestDto.getHelpfulnessNumerator());
        review.setSummary(reviewRequestDto.getSummary());
        review.setText(reviewRequestDto.getText());
        review.setScore(reviewRequestDto.getScore());
        review.setDateTime(reviewRequestDto.getDateTime());
        review.setUser(userService.get(reviewRequestDto.getUserId()));
        review.setProduct(productService.get(reviewRequestDto.getProductId()));
        return review;
    }
}
