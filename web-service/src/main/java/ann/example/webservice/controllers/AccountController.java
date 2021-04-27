package ann.example.webservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ann.example.webservice.domain.Account;
import ann.example.webservice.domain.Currency;
import ann.example.webservice.services.AccountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/")
	@ApiOperation(value = "Get all Accounts")
	public List<Account> index(){
		return accountService.getAccountsList();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Find Account by Id",
				  notes = "Provide an id to look up specific Account from the DataBase")
	public Account show(@PathVariable int id) {
		return accountService.getAccountById(id);
	}
	
	@GetMapping("/n/{number}")
	@ApiOperation(value = "Find Account by Number",
	  			  notes = "Provide a number to look up specific Account from the DataBase")
	public Account show(@PathVariable String number) {
		return accountService.getAccountByNumber(number);
	}
	
	@GetMapping("/c/{currency}")
	@ApiOperation(value = "Find Accounts by Currency",
	  			  notes = "Provide a currency to look up specific Account from the DataBase")
	public List<Account> show(@PathVariable Currency currency) {
		return accountService.getAccountByCurrency(currency);
	}
	 
	
}
