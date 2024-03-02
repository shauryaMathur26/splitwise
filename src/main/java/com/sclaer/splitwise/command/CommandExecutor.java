package com.sclaer.splitwise.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {


    //I have autowired this list. Spring will populate this list with all implementations of <<Command>> it finds.
    // It is possible because we have made sure SettleUpUserCommand and SettleUpGroupCommand are both @Components too(thus are spring managed)
    @Autowired
    private List<Command> commandList;//SettleUpUserCommand,CreateUserCommand

    // Way 2 to achieve the same thing as above.
//    @Autowired
//    public CommandExecutor(SettleUpUserCommand settleUpUserCommand,SettleUpGroupCommand settleUpGroupCommand){
//        commandList.add(settleUpUserCommand);
//        commandList.add(settleUpGroupCommand);
//    }

    public void execute(String input){

        for(Command command : commandList){
            if(command.matches(input)){
                command.execute(input);
                return;
            }
        }
        throw new RuntimeException("Invalid Command");

    }
}
