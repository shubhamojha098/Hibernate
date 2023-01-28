package tbclass.inherit;

import javax.persistence.Entity;

@Entity
public class MyEmployee extends Emp{
	private String Company;

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	
}
