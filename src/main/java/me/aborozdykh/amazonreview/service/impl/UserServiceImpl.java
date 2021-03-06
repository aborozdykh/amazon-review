package me.aborozdykh.amazonreview.service.impl;

import java.util.List;
import java.util.Set;
import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.dto.UserReviewsCountDto;
import me.aborozdykh.amazonreview.repository.UserRepository;
import me.aborozdykh.amazonreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Set<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserReviewsCountDto> findMostActiveUsers(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return userRepository.findMostActiveUsers(pageable).toList();
    }
}
