package me.aborozdykh.amazonreview.service.impl;

import java.io.IOException;
import java.util.List;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.entity.mappers.ProductMapper;
import me.aborozdykh.amazonreview.entity.mappers.ReviewMapper;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.DataReader;
import me.aborozdykh.amazonreview.service.ProductService;
import me.aborozdykh.amazonreview.service.ReviewService;
import me.aborozdykh.amazonreview.service.UserService;
import me.aborozdykh.amazonreview.util.DataReaderUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Andrii Borozdykh
 */
@Service
public class DataReaderImpl implements DataReader {
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;

    public DataReaderImpl(UserMapper userMapper,
                          ProductMapper productMapper,
                          ReviewMapper reviewMapper,
                          UserService userService,
                          ProductService productService,
                          ReviewService reviewService) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @Override
    public void save(MultipartFile file) {
        try {
            List<ReviewRequestDto> dataFromFile = DataReaderUtil.getDataFromFile(file.getInputStream());
            for (ReviewRequestDto reviewRequestDto : dataFromFile) {
                var user = userMapper.getUserFromReviewRequestDto(reviewRequestDto);
                userService.save(user);
                var product = productMapper.getProductFromReviewRequestDto(reviewRequestDto);
                productService.save(product);
                var review = reviewMapper.getReviewFromReviewRequestDto(reviewRequestDto);
                reviewService.save(review);
            }
        } catch (IOException e) {
            throw new RuntimeException("Fail to store csv data: " + e.getMessage());
        }
    }
}
