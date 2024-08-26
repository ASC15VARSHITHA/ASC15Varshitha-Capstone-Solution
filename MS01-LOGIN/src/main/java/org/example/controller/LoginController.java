package org.example.controller;

import org.example.model.BookingDTO;
import org.example.model.LoginDTO;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/loginUser")
    public List<BookingDTO> loginUser(@RequestBody LoginDTO loginDTO) {

    return loginService.login(loginDTO.getEmail(), loginDTO.getPassword());
    }

}
