package com.example.SeedsUserAuth.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testRegisterNewUser() {
        User newUser = new User();
        newUser.setUsername("testUser");
        newUser.setPassword("encodedPassword");

        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        User savedUser = userService.registerNewUser("testUser", "password123");

        assertNotNull(savedUser);
        assertEquals("testUser", savedUser.getUsername());
        assertEquals("encodedPassword", savedUser.getPassword());
    }

    @Test
    public void testFindByUsername() {
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setPassword("password123");

        when(userRepository.findByUsername("existingUser")).thenReturn(Optional.of(existingUser));

        User foundUser = userService.findByUsername("existingUser");

        assertNotNull(foundUser);
        assertEquals("existingUser", foundUser.getUsername());
        assertEquals("password123", foundUser.getPassword());
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setPassword("encodedNewPassword");

        when(userRepository.findByUsername("existingUser")).thenReturn(Optional.of(existingUser));
        when(passwordEncoder.encode("newPassword")).thenReturn("encodedNewPassword");
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        User updatedUser = userService.updateUser("existingUser", "newPassword");

        assertNotNull(updatedUser);
        assertEquals("existingUser", updatedUser.getUsername());
        assertEquals("encodedNewPassword", updatedUser.getPassword());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}
