package me.aborozdykh.amazonreview.entity.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class UserReviewsCountDto {
    private String userId;
    private String profileName;
    private Long reviewsCount;
}
