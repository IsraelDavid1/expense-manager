package com.israel.expensemanager.repositories;

import com.israel.expensemanager.models.ExpensesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface ExpensesRepository extends JpaRepository<ExpensesModel, UUID> {
    @Query("""
    SELECT COALESCE(SUM(em.price), 0)
    FROM ExpensesModel em
    WHERE em.user.id = :userId
    """)
    BigDecimal sumAllExpensesByUser(@Param("userId") UUID userId);
}
