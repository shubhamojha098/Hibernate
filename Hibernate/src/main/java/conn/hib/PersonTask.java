package conn.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersonTask {
public static void addRecord() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc=new Scanner(System.in);
	Person p=new Person();
	System.out.println("Enter Person Name");
	String pname=sc.nextLine();
	System.out.println("Enter the Department name");
	String department=sc.nextLine();
	System.out.println("Enter the person age");
	int age=Integer.parseInt(sc.nextLine());
	Department d=new Department();
	d.setDepartment(department);
	session.save(d);			//save department
	p.setAge(age);
	p.setPname(pname);
	p.setDepartment(d);
	session.save(p);		//save person
	t.commit();
}

static public void show() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Query q=session.createQuery("From Person");
	List<Person>pers=q.list();
	for (Person person : pers) {
		System.out.println(person.getPname()+":"+person.getAge()+":"+person.getDepartment().getDepartment());//p.getDepartment is the object of department we created in person class
	}//and .getperson() is the getter method we created in departments
	t.commit();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addRecord();
		show();
		addRecord();

	}

}
