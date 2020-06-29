package me.aborozdykh.amazonreview.entity.dto;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */

@EqualsAndHashCode
@Getter
@Setter
public class ReviewRequestDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private short score;
    private LocalDateTime dateTime;
    private String summary;
    private String text;
}
