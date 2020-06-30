package me.aborozdykh.amazonreview.service;

import java.util.List;
import java.util.Set;
import me.aborozdykh.amazonreview.entity.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> saveAll(Set<Product> products);

    Product get(String id);

    List<Product> findMostCommented(Long limit, Long offset);
}
