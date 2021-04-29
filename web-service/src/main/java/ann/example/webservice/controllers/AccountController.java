package ann.example.webservice.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import ann.example.webservice.domain.Account;
import ann.example.webservice.domain.Currency;
import ann.example.webservice.services.AccountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
public class AccountController {

	 private final static Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/")
	@ApiOperation(value = "Get all Accounts")
	public ResponseEntity<List<Account>> index(){
		try {
			return ResponseEntity.ok(accountService.getAccountsList());
		} catch (DataAccessException e) {
			LOG.error("Could not get accounts List!", e);
			return ResponseEntity.status(500).build();
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Find Account by Id",
				  notes = "Provide an id to look up specific Account from the DataBase")
	public ResponseEntity<Account> show(@PathVariable int id) {
		try {
			return ResponseEntity.ok(accountService.getAccountById(id));
		} catch (DataAccessException e) {
			LOG.error("Could not get account by id!", e);
			return ResponseEntity.status(500).build();
		}		
	}

	@GetMapping("/n/{number}")
	@ApiOperation(value = "Find Account by Number",
	  			  notes = "Provide a number to look up specific Account from the DataBase")
	public ResponseEntity<Account> show(@PathVariable String number) {
		try {
			return ResponseEntity.ok(accountService.getAccountByNumber(number));
		} catch (DataAccessException e) {
			LOG.error("Could not get account by number!", e);
			return ResponseEntity.status(500).build();
		}	
	}
	
	@GetMapping("/c/{currency}")
	@ApiOperation(value = "Find Accounts by Currency",
	  			  notes = "Provide a currency to look up specific Account from the DataBase")
	public ResponseEntity<List<Account>> show(@PathVariable Currency currency) {
		try {
			return ResponseEntity.ok(accountService.getAccountByCurrency(currency));
		} catch (DataAccessException e) {
			LOG.error("Could not get accounts List by currency!", e);
			return ResponseEntity.status(500).build();
		}			
	}
	 
	
}
