package onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Company {
@Id
@GeneratedValue
private int id;
private String companyname;
@OneToMany(targetEntity = Customer.class,cascade=CascadeType.ALL)
@JoinColumn(name="comp_id",referencedColumnName = "id")
private Set Customer;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public Set getCustomer() {
	return Customer;
}
public void setCustomer(Set customer) {
	Customer = customer;
}
}
