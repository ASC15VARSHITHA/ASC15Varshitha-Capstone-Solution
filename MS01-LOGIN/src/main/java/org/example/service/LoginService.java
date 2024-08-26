package org.example.service;

import org.example.entity.LoginEntity;
import org.example.feignclient.FeignProxy;
import org.example.model.BookingDTO;
import org.example.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class LoginService {
    @Autowired
    FeignProxy feignProxy;
    @Autowired
    private LoginRepository loginRepository;

    private static final Integer MAX_ATTEMPTS = 3;
    private static final Duration lockDuration = Duration.ofMinutes(30);
    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");


    //For Auto generation of Login Id
    public String substringLoginId() {
        Long userIdCount = loginRepository.count() + 1;
        return String.format("L%04d", userIdCount);
    }

    // Validations and Exceptions
    public List<BookingDTO> login(String email, String password) {
        try {


            if (email == null) {
                return null;
            }

            if (password == null) {
                return null;
            }

            if (!emailPattern.matcher(email).matches()) {
                return null;
            }

            if (!passwordPattern.matcher(password).matches()) {
                return null;
            }

            LoginEntity user = loginRepository.findByEmail(email);

            if (user == null) {
                return null;
            }


            if (user.getAccountDisabled() != null) {
                if (user.getLockTime().plus(lockDuration).isBefore(LocalDateTime.now())) {
                    user.setAccountDisabled(false);
                    user.setNoOfFailedAttempts(0);
                    user.setLockTime(null);
                } else {
                    return null;
                }
            }
            if (!user.getPassword().equals(password)) {
                user.setNoOfFailedAttempts(user.getNoOfFailedAttempts() + 1);
                if (user.getNoOfFailedAttempts() >= MAX_ATTEMPTS) {
                    user.setAccountDisabled(true);
                    user.setLockTime(LocalDateTime.now());
                }
                loginRepository.save(user);
                return null;
            }
            user.setNoOfFailedAttempts(0);
            loginRepository.save(user);
            return feignProxy.getAllBookings();
        }
        catch (NullPointerException nullPointerException) {
            return null;
        }
    }

}


