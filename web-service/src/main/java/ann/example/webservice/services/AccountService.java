package ann.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ann.example.webservice.dao.AccountRepo;
import ann.example.webservice.domain.Account;
import ann.example.webservice.domain.Currency;

@Service
public class AccountService {

	@Autowired
	AccountRepo accountRepo;

	public List<Account> getAccountsList() {
		return accountRepo.findAll();
	}

	public Account getAccountById(int id) {
		return accountRepo.findById(id);
	}

	public void saveAccount(Account account) {
		accountRepo.save(account);
	}

	public void deleteAccountById(int id) {
		accountRepo.deleteById(id);
	}

	public Account getAccountByNumber(String number) {
		return accountRepo.findByNumber(number);
	}
	
	public List<Account> getAccountByCurrency(Currency currency) {
		return accountRepo.findByCurrency(currency);
	}
	
	public void updateAccount(int id, Account newAccount) {
		Account account = accountRepo.findById(id);		
		
		account.setRest(newAccount.getRest());
		account.setNumber(newAccount.getNumber());
		account.setCurrency(newAccount.getCurrency());
		
		accountRepo.save(account);
	}
	
}
