package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
