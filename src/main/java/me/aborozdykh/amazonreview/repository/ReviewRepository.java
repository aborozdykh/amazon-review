package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrii Borozdykh
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
