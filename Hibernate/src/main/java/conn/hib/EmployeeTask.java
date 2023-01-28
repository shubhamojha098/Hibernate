package conn.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class EmployeeTask {
static void addRecord() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Name");
	String name=sc.nextLine(); 
	System.out.println("Enter the Address");
	String address=sc.nextLine(); 
	System.out.println("Enter the Mobile");
	String mobile=sc.nextLine(); 
	Employee e=new Employee();
	e.setEmpname(name);
	e.setEmpaddress(address);
	e.setEmpmobile(mobile);
	
	session.save(e);
	t.commit();
	System.out.println("Data Saved Successfully");
}
//Show Record
static public void getEmployee() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Query q=session.createQuery("From Employee");
	List<Employee> emp=q.list();
	for(Employee e:emp) {
		System.out.println(e.getId()+":"+e.getEmpname()+":"+e.getEmpaddress());
	}
	t.commit();
}
//Search
static public void getEmployeeById() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter emp id you want to Search");
	int eid=sc.nextInt();
	Query q=session.createQuery("From Employee e where e.id=:id" );
	q.setParameter("id", eid);
	List<Employee> list=q.list();
	for(Employee e:list) {
		System.out.println("Name=:"+e.getEmpname());
		System.out.println("Address=:"+e.getEmpaddress());
		System.out.println("Mobile=:"+e.getEmpmobile());
	}
}
//Delete Record
static public void deleteEmployeeById() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter Employee Id You want to delete");
	int eid=sc.nextInt();
	Query q=session.createQuery("From Employee e where e.id=:id" );
	q.setParameter("id", eid);
	List<Employee> list=q.list();
	if(list.size()>0) {
		Employee e=list.get(0);
		session.delete(e);
	}else {
		System.out.println("No Data Found");
	}
	t.commit();
}
static public void update() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Id you want to Update");
	int eid=Integer.parseInt(sc.nextLine());

	System.out.println("Enter the name");
	String name=sc.nextLine();
	
	System.out.println("Enter the Address");
	String address=sc.nextLine();
	System.out.println("Enter the Mobile");
	String mobile=sc.nextLine();
	Query q=session.createQuery("From Employee e where e.id=:id" );
	q.setParameter("id", eid);
	List<Employee>list=q.list();
	if(list.size()>0) {
		Employee e=list.get(0);
		e.setEmpname(name);
		e.setEmpaddress(address);
		e.setEmpmobile(mobile);
		session.update(e);
	}else {
        System.out.println("Invalid ID");
		}
	t.commit();
}

public static void getEmployeeByCriteria() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Criteria criteria=session.createCriteria(Employee.class);
	criteria.add(Restrictions.eq("empName", "Shubham"));
	criteria.add(Restrictions.eq("empAddress", "patna"));
	criteria.add(Restrictions.like("empName", "_a%"));
	criteria.setMaxResults(2);
	
	
}
	public static void main(String[] args) {
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter 1 to Add Record");
			System.out.println("Enter 2 to Show Record");
			System.out.println("Enter 3 to  Delete Record");
			System.out.println("Enter 4 to Search Record");
			System.out.println("Enter 5 to Update Record");
			System.out.println("Enter 6 to Search by Criteria");
			System.out.println("Enter 7 to Exit");
			int ch=sc.nextInt();
			switch (ch) {
			case 1: 
				addRecord();
				break;
			case 2:
				getEmployee();
				break;
			case 3:
				deleteEmployeeById();
				break;
			case 4:
				getEmployeeById();
				break;
			case 5:
				update();
				break;
			case 6:
			getEmployeeByCriteria();
			case 7:
				System.exit(0);
			default:
				System.out.println("No Data Found");
			}
		}

	}

}
