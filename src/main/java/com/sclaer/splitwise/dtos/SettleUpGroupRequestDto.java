package com.sclaer.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettleUpGroupRequestDto {
    private Long groupId;
}
