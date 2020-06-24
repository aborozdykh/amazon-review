package me.aborozdykh.amazonreview.entity.mappers;

import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;

/**
 * @author Andrii Borozdykh
 */
public class UserMapper {
    public User getUserFromReviewRequestDto(ReviewRequestDto reviewRequestDto) {
        if (reviewRequestDto == null) {
            return null;
        }
        var user = new User();
        user.setId(reviewRequestDto.getUserId());
        user.setProfileName(reviewRequestDto.getProfileName());
        return user;
    }
}
