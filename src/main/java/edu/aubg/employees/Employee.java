package edu.aubg.employees;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Annotate Employee class as JPA Entity class which is mapped to the database table
// The database table name is set to "EMPLOYEES" */

@Entity(name="EMPLOYEES")
public class Employee {
/* Identify id as this entity's unique identifier. The id
value is auto-generated. */
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String userName;
private String title;
private long salary;
private String location;
private String email;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getTitle() {
return title;
}
public void setTitle(String title) {
this.title = title;
}
public long getSalary() {
return salary;
}
public void setSalary(long salary) {
this.salary = salary;
}
public String getLocation() {
return location;
}
public void setLocation(String location) {
this.location = location;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
}