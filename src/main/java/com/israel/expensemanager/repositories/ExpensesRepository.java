package com.israel.expensemanager.repositories;

import com.israel.expensemanager.models.ExpensesModel;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ExpensesRepository extends JpaRepository<ExpensesModel, UUID> {
    @NonNull
    Optional<ExpensesModel> findById(@NonNull UUID id);

    @Query("""
    SELECT COALESCE(SUM(e.price), 0)
    FROM Expenses e
    WHERE e.user.id = :userId
    """)
    BigDecimal sumAllExpensesByUser(@Param("userId") UUID userId);

    @Query("""
    SELECT e
    FROM Expenses e
    WHERE e.user.id = :userId
    AND e.date BETWEEN
    :beginDate AND :lastDate
    """)
    List<ExpensesModel> findByMonth(@Param("userId") UUID userId,
                                    @Param("beginDate") LocalDateTime beginDate,
                                    @Param("lastDate") LocalDateTime lastDate);
}
