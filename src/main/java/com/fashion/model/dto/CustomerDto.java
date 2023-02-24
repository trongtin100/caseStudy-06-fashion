package com.fashion.model.dto;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
@EqualPasswordConstraint
public class CustomerDto {
    private Long id;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Pattern(regexp = "^[a-zA-Z0-9]{2,60}$*", message = "Name is invalid")
    @NotNull(message="Name is not empty")
    private String username;

    @NotNull(message = "Email not empty")
    @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})", message = "Email invalid")
    @EqualPasswordConstraint
    private String email;

    @NotNull (message = "Email not empty")
    @Min(value = 8, message = "Password phải từ 8 kí tự trở lên")
    @Pattern(regexp = "^[a-zA-Z0-9._-]{8,40}$" , message = "Password phải từ 8 kí tự trở lên")
    private String password;
    private boolean status;
    private String avatar;
    private String createdTime;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String username, String email, String password, boolean status, String avatar, String createdTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
        this.createdTime = createdTime;
    }

    public CustomerDto(String username, String email, String password, boolean status, String avatar, String createdTime) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
        this.createdTime = createdTime;
    }
}

