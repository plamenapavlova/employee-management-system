package edu.aubg.employees;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/* This interface extends the JpaRepository interface which
provides all the basic CRUD methods for the Employee table. */
public interface EmployeeRepository extends
JpaRepository<Employee, Long> {
// An empty class! JpaRepository methods are used without modification!
    @Query("select s from EMPLOYEES s where s.salary > 5000 and s.location = 'Sofia'")
    List<Employee> findEmployee();
}   