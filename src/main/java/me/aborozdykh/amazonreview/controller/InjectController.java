package me.aborozdykh.amazonreview.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import me.aborozdykh.amazonreview.entity.Review;
import me.aborozdykh.amazonreview.entity.Role;
import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.entity.mappers.ProductMapper;
import me.aborozdykh.amazonreview.entity.mappers.ReviewMapper;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.DataReader;
import me.aborozdykh.amazonreview.service.ProductService;
import me.aborozdykh.amazonreview.service.ReviewService;
import me.aborozdykh.amazonreview.service.RoleService;
import me.aborozdykh.amazonreview.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final DataReader dataReader;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;

    public InjectController(RoleService roleService,
                            DataReader dataReader,
                            UserMapper userMapper,
                            ProductMapper productMapper,
                            ReviewMapper reviewMapper,
                            UserService userService,
                            ProductService productService,
                            ReviewService reviewService) {
        this.roleService = roleService;
        this.dataReader = dataReader;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void insertRolesToDb() {
        roleService.save(Role.of("ADMIN"));
        roleService.save(Role.of("USER"));
    }

//    @PostConstruct
//    public void putDataFromFileToDb() {
//        List<ReviewRequestDto> dataFromFile = dataReader.getDataFromFile();
//        for (ReviewRequestDto reviewRequestDto : dataFromFile) {
//            var user = userMapper.getUserFromReviewRequestDto(reviewRequestDto);
//            userService.save(user);
//            var product = productMapper.getProductFromReviewRequestDto(reviewRequestDto);
//            productService.save(product);
//            var review = reviewMapper.getReviewFromReviewRequestDto(reviewRequestDto);
////            var reviewList = List.of(review);
////            user.setReviews(reviewList);
////            product.setReviews(reviewList);
//            reviewService.save(review);
//        }
//    }
}
