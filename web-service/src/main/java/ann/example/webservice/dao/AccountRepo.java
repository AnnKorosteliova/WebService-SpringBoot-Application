package ann.example.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ann.example.webservice.domain.Account;
import ann.example.webservice.domain.Currency;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{
	
	public Account findByNumber(String number);
	public Account findByCurrency(Currency currency);
}
