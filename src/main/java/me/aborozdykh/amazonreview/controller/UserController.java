package me.aborozdykh.amazonreview.controller;

import java.util.List;
import java.util.stream.Collectors;
import me.aborozdykh.amazonreview.entity.dto.UserResponseDto;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/user")
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
}
