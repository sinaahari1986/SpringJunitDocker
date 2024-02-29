package com.sadad.spring.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserEntityIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    private UserEntity userEntity;

    @BeforeEach
    void setup() {
        userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setFirstName("sina");
        userEntity.setLastName("ahari");
        userEntity.setEmail("sina@tset2.com");
        userEntity.setEncryptedPassword("12345678");
    }

    @Test
    void testUserEntity_whenValidUserDetailsProvided_shouldReturnStoredUserDetails() {
        //Arrange
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setFirstName("sina");
        userEntity.setLastName("ahari");
        userEntity.setEmail("sina@tset1.com");
        userEntity.setEncryptedPassword("12345678");

        //Act
        UserEntity storedUserEntity = testEntityManager.persistAndFlush(userEntity);

        //Assert
        Assertions.assertTrue(storedUserEntity.getId() > 0);
        Assertions.assertEquals(userEntity.getUserId(), storedUserEntity.getUserId());
        Assertions.assertEquals(userEntity.getFirstName(), storedUserEntity.getFirstName());
        Assertions.assertEquals(userEntity.getLastName(), storedUserEntity.getLastName());
        Assertions.assertEquals(userEntity.getEmail(), storedUserEntity.getEmail());
        Assertions.assertEquals(userEntity.getEncryptedPassword(), storedUserEntity.getEncryptedPassword());
    }

    @Test
    void testUserEntity_whenFirstNameIsTooLong_shouldThrowException() {
        //Arrange
        userEntity.setFirstName("7891012345678910121111111111111111111111111111111111111111111111134567891012345678910");

        //ACT&&Assert
        assertThrows(PersistenceException.class, () -> {
                    testEntityManager.persistAndFlush(userEntity);
                }, "is Exception"
        );
    }

}