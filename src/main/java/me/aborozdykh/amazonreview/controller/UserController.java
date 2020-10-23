package me.aborozdykh.amazonreview.controller;

import java.util.List;
import java.util.stream.Collectors;
import me.aborozdykh.amazonreview.entity.dto.UserResponseDto;
import me.aborozdykh.amazonreview.entity.dto.UserReviewsCountDto;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Borozdykh
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll().stream()
                .map(userMapper::getUserResponseDtoFromUser)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-active")
    public List<UserReviewsCountDto> getMostActiveUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") int limit) {
        return userService.findMostActiveUsers(page, limit);
    }
}
