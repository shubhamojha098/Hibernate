package embeded;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import conn.hib.Employee;
import conn.hib.HibernateUtill;

public class UserTask {
public static void addRecord() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter Name");
	String name=sc.nextLine();
	System.out.println("Enter House No");
	String houseno=sc.nextLine();
	System.out.println("Enter City");
	String city=sc.nextLine();
	System.out.println("Enter State");
	String state=sc.nextLine();
	System.out.println("Enter Country");
	String country=sc.nextLine();
	System.out.println("Enter Street");
	String Street=sc.nextLine();
	System.out.println("Enter Pincode");
	int pincode=Integer.parseInt(sc.nextLine());
	Address add=new Address();
	add.setHouse_no(houseno);
	add.setStreet(Street);
	add.setPincode(Street);
	add.setCity(city);
	add.setState(state);
	add.setCountry(country);
	User u=new User();
	u.setName(name);
	u.setAddress(add);
	session.save(u);
	t.commit();
}
	public static void updateRecord() {
		Session session=HibernateUtill.getSession();
		Transaction t=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id");
		int id=sc.nextInt();
		Query q=session.createQuery("From User u where u.id=:id");
		q.setParameter("id", id);
		List<User>list=q.list();
		User u=list.get(0);
		u.getAddress().setCity("Varanasi");
		u.getAddress().setState("UP");
		session.saveOrUpdate(u);
		t.commit();
	}
	public static void delete() {
		Session session=HibernateUtill.getSession();
		Transaction t=session.beginTransaction();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employee Id You want to delete");
		int uid=sc.nextInt();
		Query q=session.createQuery("From User u where u.id=:id" );
		q.setParameter("id", uid);
		List<User> list=q.list();
		if(list.size()>0) {
			User e=list.get(0);
			session.delete(e);
		}else {
			System.out.println("No Data Found");
		}
		t.commit();
	}
	public static void show() {
		Session session=HibernateUtill.getSession();
		Transaction t=session.beginTransaction();
		Query q=session.createQuery("From User");
		List<User> emp=q.list();
		for(User u:emp) {
			System.out.println(u.getUid()+":"+
		u.getName()+":"+
		u.getAddress().getHouse_no()+":"+
		u.getAddress().getStreet()+":"+
		u.getAddress().getCity()+":"+
		u.getAddress().getState()+":"+
		u.getAddress().getCountry()+":"+
		u.getAddress().getPincode());
		}
		t.commit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addRecord();
		//updateRecord();
		//show();
		//delete();

	}

}
