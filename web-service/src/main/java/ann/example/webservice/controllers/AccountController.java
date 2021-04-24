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

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/")
	public List<Account> index(){
		return accountService.getAccountsList();
	}
	
	@GetMapping("/{id}")
	public Optional<Account> show(@PathVariable int id) {
		return accountService.getAccountById(id);
	}
	
	@GetMapping("/n/{number}")
	public Account show(@PathVariable String number) {
		return accountService.getAccountByNumber(number);
	}
	
	@GetMapping("/c/{currency}")
	public Account show(@PathVariable Currency currency) {
		return accountService.getAccountByCurrency(currency);
	}
	 
	
}
