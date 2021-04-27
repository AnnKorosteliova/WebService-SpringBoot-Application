package ann.example.webservice.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The unique id of the Account")
	private Integer id;	
	@Column(unique = true, length = 30)
	@ApiModelProperty(notes = "The unique number of the Account")
	private String number;
	@Column(length = 25)
	@ApiModelProperty(notes = "The rest which is on the Account")
	private Float rest;
	@Enumerated
	@Type(type = "ann.example.webservice.domain.Currency")
	@ApiModelProperty(notes = "The currency: USD, EUR, MDL")
	private Currency currency;	
	@CreationTimestamp
	private Timestamp creationDate;	
	@UpdateTimestamp
	private Timestamp lastModificationDate;
	
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
