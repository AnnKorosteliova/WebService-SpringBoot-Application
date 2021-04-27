package ann.example.webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ann.example.webservice.domain.Account;
import ann.example.webservice.services.AccountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin/account")
public class AdminController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create new Account",
	  			  notes = "Provide a new Account to add specific Account in the DataBase")
	public String create(@RequestBody Account account) {
		accountService.saveAccount(account);
		return "Account is created!";
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Account by Id",
	  			  notes = "Provide an id to delete specific Account from the DataBase")
	public String destroy(@PathVariable int id) {
		accountService.deleteAccountById(id);
		return "Account with id " + id + " is deleted!";
	}
	
	@ApiOperation(value = "Update Account by Id",
			      notes = "Provide an id and new properties to update specific Account from the DataBase")
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody Account newAccount) {
		accountService.updateAccount(id, newAccount);		
		return "Account with id " + id + " is updated!";
	}
	
	
}
