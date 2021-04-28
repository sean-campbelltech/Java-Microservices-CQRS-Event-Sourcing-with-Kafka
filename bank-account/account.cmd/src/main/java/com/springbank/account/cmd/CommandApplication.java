package com.springbank.account.cmd;

import org.springframework.boot.SpringApplication;
import com.springbank.account.cmd.api.commands.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import com.springbank.account.cmd.api.commands.OpenAccountCommand;
import com.springbank.account.cmd.api.commands.CloseAccountCommand;
import com.springbank.account.cmd.api.commands.DepositFundsCommand;
import com.springbank.account.cmd.api.commands.WithdrawFundsCommand;
import com.springbank.cqrs.core.infrastructure.CommandDispatcher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CommandApplication {

	@Autowired
	private CommandDispatcher commandDispatcher;

	@Autowired
	private CommandHandler commandHandler;

	public static void main(String[] args) {
		SpringApplication.run(CommandApplication.class, args);
	}

	@PostConstruct
	public void registerHandlers() {
		commandDispatcher.registerHandler(OpenAccountCommand.class, commandHandler::handle);
		commandDispatcher.registerHandler(DepositFundsCommand.class, commandHandler::handle);
		commandDispatcher.registerHandler(WithdrawFundsCommand.class, commandHandler::handle);
		commandDispatcher.registerHandler(CloseAccountCommand.class, commandHandler::handle);
	}
}
