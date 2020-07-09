package me.aborozdykh.amazonreview.entity.mappers;

import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.entity.dto.UserResponseDto;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Borozdykh
 */
@Component
public class UserMapper {
    public User getUserFromReviewRequestDto(ReviewRequestDto reviewRequestDto) {
        var user = new User();
        user.setId(reviewRequestDto.getUserId());
        user.setProfileName(reviewRequestDto.getProfileName());
        return user;
    }

    public UserResponseDto getUserResponseDtoFromUser(User user) {
        if (user == null) {
            return null;
        }
        var userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setProfileName(user.getProfileName());
        return userResponseDto;
    }
}
