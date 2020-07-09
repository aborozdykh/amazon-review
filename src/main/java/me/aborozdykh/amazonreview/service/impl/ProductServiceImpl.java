package me.aborozdykh.amazonreview.service.impl;

import java.util.List;
import java.util.Set;
import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.entity.dto.ProductReviewsCountDto;
import me.aborozdykh.amazonreview.repository.ProductRepository;
import me.aborozdykh.amazonreview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(Set<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product get(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductReviewsCountDto> findMostCommentedProducts(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findMostCommentedProducts(pageable).toList();
    }
}
