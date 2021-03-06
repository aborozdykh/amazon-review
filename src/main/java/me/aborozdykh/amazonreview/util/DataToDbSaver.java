package me.aborozdykh.amazonreview.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.entity.Review;
import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.Word;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.entity.mappers.ProductMapper;
import me.aborozdykh.amazonreview.entity.mappers.ReviewMapper;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.ProductService;
import me.aborozdykh.amazonreview.service.ReviewService;
import me.aborozdykh.amazonreview.service.UserService;
import me.aborozdykh.amazonreview.service.WordService;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Borozdykh
 */
@Component
public class DataToDbSaver {
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final WordService wordService;

    public DataToDbSaver(UserMapper userMapper,
                         ProductMapper productMapper,
                         ReviewMapper reviewMapper,
                         UserService userService,
                         ProductService productService,
                         ReviewService reviewService,
                         WordService wordService) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
        this.productService = productService;
        this.reviewService = reviewService;
        this.wordService = wordService;
    }

    public void saveToDb(List<ReviewRequestDto> reviewRequestDtoList) {
        saveUsersToDb(reviewRequestDtoList);
        saveProductsToDb(reviewRequestDtoList);
        saveReviewsToDb(reviewRequestDtoList);
        saveWordsToDb(reviewRequestDtoList);
    }

    public List<User> saveUsersToDb(List<ReviewRequestDto> reviewRequestDtoList) {
        Set<User> users = reviewRequestDtoList
                .stream()
                .map(userMapper::getUserFromReviewRequestDto)
                .collect(Collectors.toSet());
        return userService.saveAll(users);
    }

    public List<Product> saveProductsToDb(List<ReviewRequestDto> reviewRequestDtoList) {
        Set<Product> products = reviewRequestDtoList
                .stream()
                .map(productMapper::getProductFromReviewRequestDto)
                .collect(Collectors.toSet());
        return productService.saveAll(products);
    }

    public List<Review> saveReviewsToDb(List<ReviewRequestDto> reviewRequestDtoList) {
        List<Review> reviews = reviewRequestDtoList
                .stream()
                .map(reviewMapper::getReviewFromReviewRequestDto)
                .collect(Collectors.toList());
        return reviewService.saveAll(reviews);
    }

    public List<Word> saveWordsToDb(List<ReviewRequestDto> reviewRequestDtoList) {
        var wordsHashMap = new HashMap<String, Integer>();
        reviewRequestDtoList
                .stream()
                .map(ReviewRequestDto::getText)
                .map(s -> s.split("\\W+"))
                .flatMap(Arrays::stream)
                .map(s -> wordsHashMap.merge(s, 1, Integer::sum))
                .count();
        List<Word> words = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsHashMap.entrySet()) {
            var word = new Word();
            word.setId(entry.getKey());
            word.setCount(entry.getValue());
            words.add(word);
        }
        return wordService.saveAll(words);
    }
}
