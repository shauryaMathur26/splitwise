package com.sclaer.splitwise.dtos;

import com.sclaer.splitwise.models.Expense;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpGroupResponseDto {

    private List<Expense> expenses;
}
