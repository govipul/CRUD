package com.example.crud.service;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    public static final String EMAIL = "vipul.goswami@gmail.com";
    private final User sample = new User("vipul", "goswami", "vipul.goswami@gmail.com", 1L);

    @Autowired
    UserService userService;

    private final UserRepository mockUserRepository = mock(UserRepository.class);
    @Test
    void addUsers() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUser() throws NotFoundException {
        when(mockUserRepository.getUserByEmail(EMAIL)).thenReturn(sample);
        final User user = userService.getUser(EMAIL);
        assertEquals(sample, user);
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }
}