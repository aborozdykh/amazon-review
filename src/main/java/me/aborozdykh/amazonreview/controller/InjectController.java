package me.aborozdykh.amazonreview.controller;

import javax.annotation.PostConstruct;
import me.aborozdykh.amazonreview.entity.Role;
import me.aborozdykh.amazonreview.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;

    public InjectController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void insertRolesToDb() {
        roleService.save(Role.of("ADMIN"));
        roleService.save(Role.of("USER"));
    }
}
