package com.sadad.spring.controllers.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private long id;


}

