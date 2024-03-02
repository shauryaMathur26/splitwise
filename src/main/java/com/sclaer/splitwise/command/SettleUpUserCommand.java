package com.sclaer.splitwise.command;

import com.sclaer.splitwise.controllers.SettleUpController;
import com.sclaer.splitwise.dtos.SettleUpUserRequestDTO;
import com.sclaer.splitwise.dtos.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command{

    @Autowired
    private SettleUpController settleUpController;

    //UserInput -> SettleUpUser 1
    //UserInput -> CreateUser 2 Shaurya 1234

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        if(words.get(0).equalsIgnoreCase("SettleUpUser"))
            return true;
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(1));
//          Way 1
//        SettleUpUserRequestDTO settleUpUserRequestDTO = new SettleUpUserRequestDTO();
//        settleUpUserRequestDTO.setUserId(userId);

        //Way 2
//        SettleUpUserRequestDTO settleUpUserRequestDTO = new SettleUpUserRequestDTO(userId);

        SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(SettleUpUserRequestDTO.builder().userId(userId).build());
        System.out.println("DEBUG");
    }
}
