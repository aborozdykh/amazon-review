package me.aborozdykh.amazonreview.service.impl;

import me.aborozdykh.amazonreview.entity.Role;
import me.aborozdykh.amazonreview.repository.RoleRepository;
import me.aborozdykh.amazonreview.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
