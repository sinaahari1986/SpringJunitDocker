package com.sadad.spring.controllers.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserLoginRequestModel {
    private String email;
    private String password;


}
