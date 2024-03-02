package com.sclaer.splitwise.repositories;

import com.sclaer.splitwise.models.Expense;
import com.sclaer.splitwise.models.ExpenseUser;
import com.sclaer.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findAllByUser(User user);

    //findAllByUserAndExpenseUserType(User user,ExpenseUserType expenseUserType)
}

// Expense 1
// Paid : A : 1000 , B : 500
// Had to pay : A : 750 , B : 750

// ExpenseUser 1
// Expense 1 : A : paid : 1000
// ExpenseUser 2
// Expense 1 : B : paid : 500
// ExpenseUser 3
// Expense 1 : A : Had to pay : 750
// ExpenseUser 4
// Expense 1 : B : Had to pay : 750

//findAllByUser(A)
//Result
// ExpenseUser 1
// Expense 1 : A : paid : 1000
// ExpenseUser 3
// Expense 1 : A : Had to pay : 750

// ExpenseUser 1
// Expense 2 : A : paid : 1000
// ExpenseUser 3
// Expense 2 : A : Had to pay : 750