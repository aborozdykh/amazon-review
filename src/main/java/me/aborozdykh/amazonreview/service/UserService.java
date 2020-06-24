package me.aborozdykh.amazonreview.service;

import java.util.List;
import java.util.Set;
import me.aborozdykh.amazonreview.entity.User;

public interface UserService {
    User save(User user);

    List<User> saveAll(Set<User> users);

    User get(String id);

    List<User> getAll();

    List<User> findMostActiveUsers(String limit);
}
