package com.sclaer.splitwise.services;

import com.sclaer.splitwise.models.Expense;
import com.sclaer.splitwise.models.ExpenseUser;
import com.sclaer.splitwise.models.Group;
import com.sclaer.splitwise.models.User;
import com.sclaer.splitwise.repositories.ExpenseRepository;
import com.sclaer.splitwise.repositories.ExpenseUserRepository;
import com.sclaer.splitwise.repositories.GroupRepository;
import com.sclaer.splitwise.repositories.UserRepository;
import com.sclaer.splitwise.strategy.SettleUpHeapStrategy;
import com.sclaer.splitwise.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseUserRepository expenseUserRepository;

    public List<Expense> settleUpUser(Long userId){

        // 1. Validate userId and Get the user

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User Not found");
        }
        User user = userOptional.get();

        // 2. Get all expenses of the user

        //All expenseUser entries for a specific expense for a specific user
        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        // Will give duplicate expenses
//        for(ExpenseUser expenseUser : expenseUsers){
//            expenseExtractedFromUserExpense.add(expenseUser.getExpense());
//        }

        Set<Expense> uniqueExpenseSet = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers){
            uniqueExpenseSet.add(expenseUser.getExpense());
        }
        List<Expense> uniqueExpenses = uniqueExpenseSet.stream().toList();

        // 3. Compute who owes what
        // 4. Apply strategy and find all transactions to be done

        List<Expense> expensesToSettle = settleUpStrategy.settleUp(uniqueExpenses);

        // 5. Return transactions

        return expensesToSettle;
    }

    public List<Expense> settleUpGroup(Long groupId){

        // 1. Validate groupId and Get the group

        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group does not exist!");
        }
        Group userGroup = groupOptional.get();

        // 2. Get all expenses of the group

        List<Expense> expenses = expenseRepository.findAllByGroup(userGroup);

        // 3. Compute who owes what
        // 4. Apply strategy and find all transactions to be done

        List<Expense> expensesToSettle = settleUpStrategy.settleUp(expenses);

        // 5. Return transactions

        return expensesToSettle;
    }

}
