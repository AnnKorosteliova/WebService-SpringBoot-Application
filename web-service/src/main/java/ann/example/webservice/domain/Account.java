package ann.example.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	@Column(unique = true, length = 30)
	private String number;
	@Column(length = 25)
	private Float rest;
	@Enumerated
	private Currency currency;

	public Account(String number, Float rest, Currency currency) {
		this.setNumber(number);
		this.setRest(rest);
		this.setCurrency(currency);
	}
	
	public Account() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Float getRest() {
		return rest;
	}
	public void setRest(Float rest) {
		this.rest = rest;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", rest=" + rest + ", currency" + currency + "]";
	}
	
	
}
