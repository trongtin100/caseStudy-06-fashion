package com.fashion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotBlank
    private String username;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotBlank
    private String email;

    @OnDelete(action = OnDeleteAction.CASCADE)
    private String password;

    private boolean status;
    @Lob
    private byte[] avatar;

    private String createdTime;

    public Customer() {
    }

    public Customer(String username, String email, String password, boolean status, String avatar, String createdTime) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
        this.createdTime = createdTime;
    }

    public Customer(Long id, String username, String email, String password, boolean status, String avatar, String createdTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", avatar='" + avatar + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}

