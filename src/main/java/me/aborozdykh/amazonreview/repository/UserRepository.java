package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
