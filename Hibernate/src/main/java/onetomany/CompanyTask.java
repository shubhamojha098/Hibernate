package onetomany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import conn.hib.HibernateUtill;

public class CompanyTask {
public static void addrecord() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Company c=new Company();
	c.setCompanyname("Jio");
	Set<Customer> s=new HashSet<Customer>();
	
	Customer su=new Customer();
	su.setAddress("Mumbai");
	su.setName("Shinde");
	s.add(su);
	
	Customer rs=new Customer();
	rs.setAddress("Patna");
	rs.setName("Shubham");
	s.add(rs);
	
	Customer ro=new Customer();
	ro.setAddress("Lucknow");
	ro.setName("Sajid");
	s.add(ro);
	
	Customer r=new Customer();
	r.setAddress("Delhi");
	r.setName("Rishi");
	s.add(r);
	
	c.setCustomer(s);//add customer to company
	session.save(c);//save record
	t.commit();
}
public static void show() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Company c=new Company();
	Query q=session.createQuery("From Company");
	List<Company>comp=q.list();
	for (Company com : comp) {
		System.out.println("Company"+com.getCompanyname());
		Set<Customer>cus=com.getCustomer();
		for (Customer company : cus) {
			System.out.println(company.getName()+":"+company.getAddress());
		}
	}
	t.commit();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addrecord();
		show();
	}

}
