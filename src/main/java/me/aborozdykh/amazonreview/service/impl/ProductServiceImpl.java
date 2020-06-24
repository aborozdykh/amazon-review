package me.aborozdykh.amazonreview.service.impl;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.repository.ProductRepository;
import me.aborozdykh.amazonreview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product get(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findMostCommented(String limit) {
        return null;
    }
}
