package me.aborozdykh.amazonreview.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import me.aborozdykh.amazonreview.entity.Role;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.repository.RoleRepository;
import me.aborozdykh.amazonreview.service.DataReader;
import me.aborozdykh.amazonreview.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/inject")
public class InjectController {
    private RoleService roleService;
    private DataReader dataReader;

    @PostConstruct
    public void insertRolesToDb() {
        roleService.add(Role.of("ADMIN"));
        roleService.add(Role.of("USER"));
    }

    @PostConstruct
    public void putDataFromFileToDb(){
        List<ReviewRequestDto> dataFromFile = dataReader.getDataFromFile();

    }
}
