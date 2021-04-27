package ann.example.webservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ann.example.webservice.controllers.AccountController;
import ann.example.webservice.dao.AccountRepo;
import ann.example.webservice.domain.Account;
import ann.example.webservice.domain.Currency;
import ann.example.webservice.services.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
class WebServiceApplicationTests {

	@Autowired
	private AccountService service;
	
	@MockBean
	private AccountRepo repository;
	
	@Test
	public void getAccountsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Account(2, "number2", 31f, Currency.EUR), new Account(3, "number3", 354f, Currency.MDL)).collect(Collectors.toList()));
		assertEquals(2, service.getAccountsList().size());
	}
	
	@Test
	public void deleteAccountTest() {
		Account account = new Account(9, "number9", 334f, Currency.MDL);
		service.deleteAccountById(account.getId());
		verify(repository, times(1)).deleteById(account.getId());
	}

	
}
