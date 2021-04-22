package ann.example.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ann.example.webservice.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{
}
