package com.sadad.spring.controllers.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
public class UserDetailsRequestModel {

    @Size(min = 2, message = "First name must not be less than 2 characters")
    private String firstName;

    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String lastName;

    @Email
    private String email;

    @Size(min = 8, max = 16, message = "Password must be equal to or greater than 8 characters and less than 16 characters")
    private String password;

    @Size(min = 8, max = 16, message = "Repeat Password must be equal to or greater than 8 characters and less than 16 characters")
    private String repeatPassword;

}
