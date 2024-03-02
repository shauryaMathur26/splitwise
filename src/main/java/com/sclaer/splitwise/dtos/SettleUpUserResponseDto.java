package com.sclaer.splitwise.dtos;

import com.sclaer.splitwise.models.Expense;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpUserResponseDto {
    //A -> B : 100
//    Transaction -> Dummy expense
    private List<Expense> expenses;
}
