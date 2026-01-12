package com.israel.expensemanager.services;

import com.israel.expensemanager.dtos.UserRecordDto;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserModel createUser(UserRecordDto userRecordDto) {
        UserModel user = new UserModel();
        user.setName(userRecordDto.name());
        user.setPassword(userRecordDto.password());
        user.setRole("normalPrivileges"); //yet to implement roles

        return userRepository.save(user);
    }
}
