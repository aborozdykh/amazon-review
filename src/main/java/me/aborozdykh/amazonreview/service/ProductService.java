package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Product;

public interface ProductService {
    Product save(Product product);

    Product get(String id);

    List<Product> findMostCommented(String limit);
}
