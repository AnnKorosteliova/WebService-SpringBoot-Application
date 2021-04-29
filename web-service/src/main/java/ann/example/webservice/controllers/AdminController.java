package ann.example.webservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	private final static Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create new Account",
	  			  notes = "Provide a new Account to add specific Account in the DataBase")
	public ResponseEntity<String> create(@RequestBody Account account) {
		try{
			accountService.saveAccount(account);
			return new ResponseEntity<>("Account is saved", HttpStatus.OK);
		} catch(RuntimeException e) {
			String msg = "Cannot save the account!";
			LOG.error(msg, e);
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Account by Id",
	  			  notes = "Provide an id to delete specific Account from the DataBase")
	public ResponseEntity<String> destroy(@PathVariable int id) {
		try{
			accountService.deleteAccountById(id);
			return new ResponseEntity<>("Account with id " + id + " is deleted!", HttpStatus.OK);
		} catch(RuntimeException e) {
			String msg = "Cannot delete the account!";
			LOG.error(msg, e);
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@ApiOperation(value = "Update Account by Id",
			      notes = "Provide an id and new properties to update specific Account from the DataBase")
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Account newAccount) {
		try{
			accountService.updateAccount(id, newAccount);
			return new ResponseEntity<>("Account with id " + id + " is updated!", HttpStatus.OK);
		} catch(RuntimeException e) {
			String msg = "Cannot update the account!";
			LOG.error(msg, e);
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}		
	}
	
	
}
