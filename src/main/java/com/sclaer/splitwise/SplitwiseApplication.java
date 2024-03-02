package com.sclaer.splitwise;

import com.sclaer.splitwise.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner{

	@Autowired
	private CommandExecutor commandExecutor;

	Scanner sc = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {

		while(true){
			String input = sc.nextLine();
			commandExecutor.execute(input);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}


}
