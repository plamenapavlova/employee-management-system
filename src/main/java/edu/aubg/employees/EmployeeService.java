package edu.aubg.employees;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class EmployeeService {
@Autowired
private EmployeeRepository employeerepository;
// Get list of all employees from database
public List<Employee> listAll() {
return employeerepository.findAll();
}

// Save details of a single employee in database
public void save(Employee employee) {
employeerepository.save(employee);
}

// Get details of a single employee from database
public Employee get(long id) {
return employeerepository.findById(id).get();
}

// Delete details of a single employee from database
public void delete(long id) {
employeerepository.deleteById(id);
}

public List<Employee> findEmployee() {
return employeerepository.findEmployee();
}
}