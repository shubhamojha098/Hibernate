package manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subscription",uniqueConstraints = {@UniqueConstraint(columnNames = "subscription_id")})
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int subscription_id;
private String sname;
@ManyToMany(mappedBy = "subscription",fetch = FetchType.LAZY)
private Set< Reader> readers;
public int getSubscription_id() {
	return subscription_id;
}
public void setSubscription_id(int subscription_id) {
	this.subscription_id = subscription_id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public Set<Reader> getReaders() {
	return readers;
}
public void setReaders(Set<Reader> readers) {
	this.readers = readers;
}

}
