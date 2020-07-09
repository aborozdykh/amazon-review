package me.aborozdykh.amazonreview.entity.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@EqualsAndHashCode
@Getter
@Setter
public class UserResponseDto {
    private String id;
    private String profileName;
}
