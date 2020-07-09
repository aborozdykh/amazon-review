package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.User;
import me.aborozdykh.amazonreview.entity.dto.UserReviewsCountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT new me.aborozdykh.amazonreview.entity.dto.UserReviewsCountDto("
            + "u.id, u.profileName, COUNT(r)) "
            + "FROM User u "
            + "JOIN Review r ON u.id = r.user.id "
            + "GROUP BY u "
            + "ORDER BY COUNT(r) DESC, u.profileName ASC")
    Page<UserReviewsCountDto> findMostActiveUsers(Pageable pageable);
}
