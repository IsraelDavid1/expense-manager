package com.israel.expensemanager.services;

import com.israel.expensemanager.dtos.AuthenticationDTO;
import com.israel.expensemanager.exceptions.UserNotFoundException;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserModel updateUser(UUID loggedUserId, AuthenticationDTO data) {
        UserModel user = userRepository.findById(loggedUserId)
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        user.setName(data.username());
        user.setPassword(passwordEncoder.encode(data.password()));

        return userRepository.save(user);
    }


    @Transactional
    public void deleteMyAccount(UUID loggedUserId, AuthenticationDTO data) {
        UserModel user = userRepository.findById(loggedUserId)
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        if(!user.getName().equals(data.username()) || !passwordEncoder.matches(data.password(), user.getPassword())) {
            throw new AccessDeniedException("wrong user data");
        }

        userRepository.delete(user);
    }
}
