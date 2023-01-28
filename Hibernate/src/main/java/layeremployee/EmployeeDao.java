package layeremployee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import conn.hib.Employee;
import conn.hib.HibernateUtill;

public class EmployeeDao {
public List<Employee> getEmployee(){
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Query q=session.createQuery("From Employee");
	List<Employee>emp=q.list();
	t.commit();
	return emp;
}
public static void add(String name,String mobile,String add) {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Employee e=new Employee();
	e.setEmpname(name);
	e.setEmpaddress(add);
	e.setEmpmobile(mobile);
	
	session.save(e);
	t.commit();
}
public static void delete(int eid) {
	System.out.println(eid);
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
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



}
