package employee;

import exeptions.ExeptionHasAlready;
import exeptions.ExeptionMaxEmployees;
import exeptions.ExeptionNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class EmployeeService {
    private static final int COUNT = 20;
    private final List<Employee> employees = new ArrayList<>(COUNT);


    public void add(String firstName, String lostName) {
        if (employees.size() >= COUNT) {
            throw new ExeptionMaxEmployees();
        }
        Employee employee = find(firstName, lostName);
        if (employee != null) {
            throw new ExeptionHasAlready();
        }
        employees.add(new Employee(firstName, lostName));
    }

    public void remove(String firstName, String lostName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLostName().equals(lostName)) ;
            {
                employees.remove(employee);
            }
        }
        throw new ExeptionNotFound();
    }


    public Employee find(String firstName, String lostName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLostName().equals(lostName)) ;
            {
                return employee;
            }
        }
        throw new ExeptionNotFound();
    }

    public Collection<Employee> all() {
        return employees;
    }
}













