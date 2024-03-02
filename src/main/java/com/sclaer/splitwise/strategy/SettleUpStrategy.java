package com.sclaer.splitwise.strategy;

import com.sclaer.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {

    //NOTE  - give all transactions(dummy expenses) to settle up
    public List<Expense> settleUp(List<Expense> expenses);
}
