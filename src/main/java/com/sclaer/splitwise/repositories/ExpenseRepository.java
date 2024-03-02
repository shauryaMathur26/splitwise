package com.sclaer.splitwise.repositories;

import com.sclaer.splitwise.models.Expense;
import com.sclaer.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
}
