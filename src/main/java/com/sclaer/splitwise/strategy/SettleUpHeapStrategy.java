package com.sclaer.splitwise.strategy;

import com.sclaer.splitwise.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpHeapStrategy implements SettleUpStrategy{

    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //HW
        return null;
    }
}
