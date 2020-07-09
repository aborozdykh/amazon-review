package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.entity.dto.ProductReviewsCountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT new me.aborozdykh.amazonreview.entity.dto.ProductReviewsCountDto("
            + "p.id, COUNT(r)) "
            + "FROM Product p "
            + "JOIN Review r ON p.id = r.product.id "
            + "GROUP BY p "
            + "ORDER BY COUNT(r) DESC")
    Page<ProductReviewsCountDto> findMostCommentedProducts(Pageable pageable);
}
