package employee;

import exeptions.ExeptionHasAlready;
import exeptions.ExeptionMaxEmployees;
import exeptions.ExeptionNotFound;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int MAX_COUNT = 15;
    private final Map<String, Employee> employees = new HashMap<>(MAX_COUNT);

    public void add(String firstName, String lostName) {
        if (employees.size() >= MAX_COUNT) {
            throw new ExeptionMaxEmployees();
        }
        Employee employee = find(firstName, lostName);
        if (employees.containsKey(employee)) {
            throw new ExeptionHasAlready();
        }
        var key = (firstName + "_" + lostName).toLowerCase();
        employees.put(key, employee);
    }

    public void remove(String firstName, String lostName) {
        var key = (firstName + "_" + lostName).toLowerCase();
        if (employees.containsKey(key)) {
            employees.remove(key);
        }
        throw new ExeptionNotFound();
    }


    public Employee find(String firstName, String lostName) {
        var key = (firstName + "_" + lostName).toLowerCase();
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new ExeptionNotFound();
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}













