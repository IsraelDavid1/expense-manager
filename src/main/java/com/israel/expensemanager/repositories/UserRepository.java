package com.israel.expensemanager.repositories;

import com.israel.expensemanager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByName(String name);
}
