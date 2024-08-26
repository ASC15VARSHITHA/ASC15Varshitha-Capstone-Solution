package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class AdminEntity {
    @Id
    @Column(name = "login_id")
    private String loginId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "no_of_attempts_left" )
    private Integer noOfFailedAttempts;
    @Column(name = "is_account_disabled" , columnDefinition = "boolean default false")
    private Boolean isAccountDisabled;
    @Column(name = "lock_time")
    private LocalDateTime lockTime;

    //Default Constructor
    public AdminEntity() {}

    //Constructor
    public AdminEntity(String loginId, String email, String password, Integer noOfFailedAttempts, Boolean isAccountDisabled, LocalDateTime lockTime) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
        this.noOfFailedAttempts = noOfFailedAttempts;
        this.isAccountDisabled = isAccountDisabled;
        this.lockTime = lockTime;
    }

    //Getters and Setters
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNoOfFailedAttempts() {
        return noOfFailedAttempts;
    }

    public void setNoOfFailedAttempts(Integer noOfFailedAttempts) {
        this.noOfFailedAttempts = noOfFailedAttempts;
    }

    public Boolean getAccountDisabled() {
        return isAccountDisabled;
    }

    public void setAccountDisabled(Boolean accountDisabled) {
        isAccountDisabled = accountDisabled;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "loginId='" + loginId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", noOfFailedAttempts=" + noOfFailedAttempts +
                ", isAccountDisabled=" + isAccountDisabled +
                ", lockTime=" + lockTime +
                '}';
    }
}
