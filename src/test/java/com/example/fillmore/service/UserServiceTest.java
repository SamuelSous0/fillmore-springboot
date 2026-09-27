package com.example.fillmore.service;

import com.example.fillmore.dto.request.LoginRequestDTO;
import com.example.fillmore.dto.request.UserRequestDTO;
import com.example.fillmore.dto.response.UserResponseDTO;
import com.example.fillmore.exception.BusinessException;
import com.example.fillmore.exception.ResourceNotFoundException;
import com.example.fillmore.model.User;
import com.example.fillmore.model.UserType;
import com.example.fillmore.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    // ==========================================
    // Cenários de Teste: createUser
    // ==========================================
    
    @Test
    @DisplayName("Deve criar usuário com sucesso quando os dados forem válidos")
    void shouldCreateUserSuccessfully() {
        // Arrange
        UserRequestDTO requestDTO = UserRequestDTO.builder()
                .name("Test User")
                .email("test@example.com")
                .password("password123")
                .type(UserType.DRIVER)
                .phone("123456789")
                .build();
                
        User savedUser = User.builder()
                .id(1L)
                .name("Test User")
                .email("test@example.com")
                .password("encodedPassword")
                .type(UserType.DRIVER)
                .phone("123456789")
                .build();

        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        UserResponseDTO responseDTO = userService.createUser(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
        assertEquals("Test User", responseDTO.getName());
        assertEquals("test@example.com", responseDTO.getEmail());
        
        verify(userRepository, times(1)).existsByEmail("test@example.com");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Deve lançar BusinessException ao tentar criar usuário com email já existente")
    void shouldThrowExceptionWhenCreatingUserWithExistingEmail() {
        // Arrange
        UserRequestDTO requestDTO = UserRequestDTO.builder()
                .email("existing@example.com")
                .build();
                
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        // Act & Assert
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            userService.createUser(requestDTO);
        });
        
        assertTrue(exception.getMessage().contains("Email already registered"));
        verify(userRepository, never()).save(any(User.class));
    }

    // ==========================================
    // Cenários de Teste: login
    // ==========================================

    @Test
    @DisplayName("Deve realizar login com sucesso quando credenciais forem corretas")
    void shouldLoginSuccessfullyWithValidCredentials() {
        // TODO: Implementar depois
    }

    @Test
    @DisplayName("Deve lançar BusinessException quando email for inválido ou inexistente no login")
    void shouldThrowExceptionWhenLoginWithInvalidEmail() {
        // TODO: Implementar depois
    }

    @Test
    @DisplayName("Deve lançar BusinessException quando a senha estiver incorreta no login")
    void shouldThrowExceptionWhenLoginWithInvalidPassword() {
        // TODO: Implementar depois
    }

    // ==========================================
    // Cenários de Teste: getUserById
    // ==========================================

    @Test
    @DisplayName("Deve retornar o usuário quando o ID for encontrado")
    void shouldReturnUserWhenIdExists() {
        // TODO: Implementar depois
    }

    @Test
    @DisplayName("Deve lançar ResourceNotFoundException quando o ID não for encontrado")
    void shouldThrowExceptionWhenUserIdDoesNotExist() {
        // TODO: Implementar depois
    }

    // ==========================================
    // Cenários de Teste: updateUser
    // ==========================================

    @Test
    @DisplayName("Deve atualizar o usuário com sucesso quando o ID existir e dados forem válidos")
    void shouldUpdateUserSuccessfully() {
        // TODO: Implementar depois
    }

    @Test
    @DisplayName("Deve lançar BusinessException ao atualizar usuário para um email já em uso por outro")
    void shouldThrowExceptionWhenUpdatingToExistingEmail() {
        // TODO: Implementar depois
    }

    // ==========================================
    // Cenários de Teste: deleteUser
    // ==========================================

    @Test
    @DisplayName("Deve deletar o usuário com sucesso quando o ID existir")
    void shouldDeleteUserSuccessfully() {
        // TODO: Implementar depois
    }

    @Test
    @DisplayName("Deve lançar ResourceNotFoundException ao tentar deletar um usuário que não existe")
    void shouldThrowExceptionWhenDeletingNonExistentUser() {
        // TODO: Implementar depois
    }
}
