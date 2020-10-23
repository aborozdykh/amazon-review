package me.aborozdykh.amazonreview.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@Getter
@Setter
@AllArgsConstructor
public class ProductReviewsCountDto {
    private String productId;
    private Long reviewsCount;
}
