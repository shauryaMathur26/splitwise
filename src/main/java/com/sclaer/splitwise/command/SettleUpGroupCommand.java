package com.sclaer.splitwise.command;

import com.sclaer.splitwise.controllers.SettleUpController;
import com.sclaer.splitwise.dtos.SettleUpGroupRequestDto;
import com.sclaer.splitwise.dtos.SettleUpGroupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{

    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String input) {
        //Validate entire input (command + the args)
        List<String> words = List.of(input.split(" "));
        if(words.get(0).equalsIgnoreCase("SettleUpGroup"))
            return true;
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId = Long.valueOf(words.get(1));


        SettleUpGroupResponseDto settleUpGroupResponseDto = settleUpController.settleUpGroup(SettleUpGroupRequestDto.builder().groupId(groupId).build());
        System.out.println("DEBUG");
    }
}
