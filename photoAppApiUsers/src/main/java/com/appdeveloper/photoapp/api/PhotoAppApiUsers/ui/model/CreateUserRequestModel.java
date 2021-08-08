package com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestModel {
    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, message = "firstName must  not be less than 2 char")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, message = "lastName must  not be less than 2 char")
    private String lastName;

    @NotNull(message = "password cannot be null")
    @Size(min = 6, max = 16, message = "password must be > 6 and < 16")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
