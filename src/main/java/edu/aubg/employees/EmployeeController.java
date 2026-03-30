package edu.aubg.employees;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;

    @RequestMapping(value="/listEmployees", method=RequestMethod.GET)
    /* Method to show list of employees */

    public String listEmployees(Model model) {
    /* Get list of employees from database */
    List<Employee> employeeList = employeeservice.findEmployee();

    /* Make the list available to the view */
    model.addAttribute("employees", employeeList); 
    return "showListEmployees";
    }

    /* Two methods that work in tandem */
    /* to create an new employee database record */
    @RequestMapping(value="/addEmployee", method=RequestMethod.GET)
    /* Method to show add new employee web form */
    public String addEmployee() {
    /* Send web form to browser user */
    return "showAddEmployeeForm";
    }

    @RequestMapping(value="/addEmployeeSubmit", method=RequestMethod.POST)
    /* Method to add submitted new employee details to database,
    and then redirect to listEmployees */

    public String addEmployeeSubmit(Employee employee) {
    /* Save web form data in database */
    employeeservice.save(employee);
    /* Finally display list of employees – including new one!
    */
    return "redirect:/employee/listEmployees";
    }

    @RequestMapping(value="/detailsEmployee/{id}",
    method=RequestMethod.GET)
    /* Show details of employee identified by id from database */
    public String detailsEmployee(@PathVariable("id") long id,
    Model model) {
    /* Get details of employee identified by id from database */
    // 1. Insert one code statement here
    Employee employee = employeeservice.get(id);
    /* Store details of this employee in model for web page */
    // 2. Insert one code statement here
    model.addAttribute("employee", employee);
    return "showEmployeeDetails";
    }


    @RequestMapping(value="/editEmployee/{id}", method=RequestMethod.GET)
    /* Browser request for update employee details form */
    /* Employee identified by id */
    public String editEmployee(@PathVariable("id") long id, Model model) {
    // Code to send form with details of employee with id to browser
        Employee employee = employeeservice.get(id);
        model.addAttribute("employee", employee);
        return "showEmployeeEditForm";
    }


    @RequestMapping(value="/editEmployeeSubmit",
    method=RequestMethod.POST)
    /* Update database with submitted edited employee details */
    public String editEmployeeSubmit(Employee employee) {
    // Code to process submitted form, updating record in database
    // Then invoke listEmployees method to display employee list
    // by redirecting to listEmployees method
        employeeservice.save(employee);
        return "redirect:/employee/listEmployees";
    }

    @RequestMapping(value="/deleteEmployee/{id}", method=RequestMethod.GET)
    /* Delete from database record of employee identified by id,
    and then redirect to listEmployees */
    public String deleteEmployee(@PathVariable("id") long id) {
    // Code to delete record specified by id
    // Then invoke listEmployees method to display employee list
    // by redirecting to listEmployees method
        employeeservice.delete(id);
        return "redirect:/employee/listEmployees";
    }


}