package me.aborozdykh.amazonreview.service;

import java.util.List;
import java.util.Set;
import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.entity.dto.ProductReviewsCountDto;

public interface ProductService {
    Product save(Product product);

    List<Product> saveAll(Set<Product> products);

    Product get(String id);

    List<Product> getAll();

    List<ProductReviewsCountDto> findMostCommentedProducts(int page, int limit);
}
