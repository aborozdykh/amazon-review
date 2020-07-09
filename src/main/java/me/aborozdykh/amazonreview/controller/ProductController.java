package me.aborozdykh.amazonreview.controller;

import java.util.List;
import java.util.stream.Collectors;
import me.aborozdykh.amazonreview.entity.dto.ProductResponseDto;
import me.aborozdykh.amazonreview.entity.dto.ProductReviewsCountDto;
import me.aborozdykh.amazonreview.entity.mappers.ProductMapper;
import me.aborozdykh.amazonreview.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Borozdykh
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public List<ProductResponseDto> getAllUsers() {
        return productService.getAll().stream()
                .map(productMapper::getProductResponseDtoFromProduct)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-commented")
    public List<ProductReviewsCountDto> getMostCommentedProducts(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") int limit) {
        return productService.findMostCommentedProducts(page, limit);
    }
}
