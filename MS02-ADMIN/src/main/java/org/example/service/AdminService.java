package org.example.service;

import org.example.entity.AdminEntity;
import org.example.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    // For Auto generation of User Login Id
    public String substringLoginId() {
        Long userIdCount = adminRepository.count() + 1;
        return String.format("L%04d", userIdCount);
    }

    //Validations and Exceptions
    public void registerUser(String email, String password) throws IllegalArgumentException {

        // if email is empty
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is empty");
        }
        //if password is empty
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is empty");
        }

        //  if the email id is already in use by some other user
        if (adminRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email is already registered");
        }

        // email expected format
        if (!emailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // password expected format
        if (!passwordPattern.matcher(password).matches()) {
            throw new IllegalArgumentException("Password is not strong enough");
        }

        // user registration method
        String loginId = substringLoginId();
        AdminEntity newUser = new AdminEntity();
        newUser.setLoginId(loginId);
        newUser.setEmail(email);
        newUser.setPassword(password);
        adminRepository.save(newUser);
    }
}
