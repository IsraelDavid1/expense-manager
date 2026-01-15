package com.israel.expensemanager.services;

import com.israel.expensemanager.exceptions.UserNotFoundException;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.models.UserRole;
import com.israel.expensemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository userRepository;

    @Transactional
    public void deleteUser(UUID loggedAdminId, String userToDelete) {
        UserModel admin = userRepository.findById(loggedAdminId)
                .orElseThrow(() -> new AccessDeniedException("Admin not found"));

        if(admin.getRole() != UserRole.ADMIN) {
            throw new AccessDeniedException("you don't have the permissions for this action");
        }

        UserModel user = userRepository.findByName(userToDelete)
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        userRepository.delete(user);
    }
}
