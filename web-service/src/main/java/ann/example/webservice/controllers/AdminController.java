package ann.example.webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ann.example.webservice.domain.Account;
import ann.example.webservice.services.AccountService;

@RestController
@RequestMapping("/admin/account")
public class AdminController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody Account account) {
		accountService.saveAccount(account);
		return "Account with id " + account.getId() + " is created!";
	}
	
	@DeleteMapping("/{id}")
	public String destroy(@PathVariable int id) {
		accountService.deleteAccountById(id);
		return "Account with id " + id + " is deleted!";
	}
	
}
