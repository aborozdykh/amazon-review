package me.aborozdykh.amazonreview.entity.mappers;

import me.aborozdykh.amazonreview.entity.Product;
import me.aborozdykh.amazonreview.entity.dto.ProductResponseDto;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Borozdykh
 */
@Component
public class ProductMapper {
    public Product getProductFromReviewRequestDto(ReviewRequestDto reviewRequestDto) {
        var product = new Product();
        product.setId(reviewRequestDto.getProductId());
        return product;
    }

    public ProductResponseDto getProductResponseDtoFromProduct(Product product) {
        var productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getId());
        return productResponseDto;
    }
}
