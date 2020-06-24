package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.User;

public interface UserService {
    User add(User user);

    User get(String id);

    List<User> findMostActiveUsers(String limit);
}
