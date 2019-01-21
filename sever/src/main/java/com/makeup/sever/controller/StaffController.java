package com.makeup.sever.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.makeup.sever.entity.Staff;
import  com.makeup.sever.repository.StaffRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {
    private StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    @RequestMapping("/staff")
    public Collection<Staff> staff() {
        return staffRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}
