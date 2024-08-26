package org.example.controller;

import org.example.model.AdminDTO;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public String register(@RequestBody AdminDTO adminDTO) {

        try {
            adminService.registerUser(adminDTO.getEmail(), adminDTO.getPassword());
            return "User registered successfully";

            //Exception
        } catch (IllegalArgumentException illegalArgumentException) {
            return illegalArgumentException.getMessage();
        }
    }
}
