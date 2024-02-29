package com.sadad.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Setter
@Getter
@ToString
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, unique=true)
    private String userId;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable=false, length=120, unique = true)
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

}
