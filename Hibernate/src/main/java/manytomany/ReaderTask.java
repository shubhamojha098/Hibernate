package manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conn.hib.HibernateUtill;

public class ReaderTask {
public static void addRecord() {
	Session session=HibernateUtill.getSession();
	Transaction t=session.beginTransaction();
	Subscription s=new Subscription();
	s.setSname("Action Movies");
	Subscription s1=new Subscription();
	s1.setSname("Horror");
	Subscription s2=new Subscription();
	s2.setSname("Animation");
	Reader r=new Reader();
	r.setName("Shubham");
	r.setEmail("shubham@gmail.com");
	Reader r1=new Reader();
	r1.setName("Shinde");
	r1.setEmail("Shinde@gmail.com");
	Reader r2=new Reader();
	r2.setName("rishi");
	r2.setEmail("rishikant@gmail.com");
	Reader r3=new Reader();
	r3.setName("Sajid");
	r3.setEmail("sajid@gmail.com");
	Set<Subscription>ss=new HashSet<Subscription>();
	Set<Reader>rr=new HashSet<Reader>();
	ss.add(s2);
	ss.add(s1);
	ss.add(s);
	rr.add(r);
	rr.add(r1);
	rr.add(r2);
	rr.add(r3);
	r.setSubscription(ss);
	r1.setSubscription(ss);
	r2.setSubscription(ss);
	r3.setSubscription(ss);
	session.save(r);
	session.save(r2);
	session.save(r3);
	session.save(r1);
	
	session.save(s);
	session.save(s1);
	session.save(s2);
	
	t.commit();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addRecord();
	}

}
