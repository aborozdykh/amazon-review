package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
