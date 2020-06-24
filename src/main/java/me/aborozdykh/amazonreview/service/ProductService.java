package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.Product;

public interface ProductService {
    Product add(Product product);

    List<Product> findMostCommented(String limit);
}
