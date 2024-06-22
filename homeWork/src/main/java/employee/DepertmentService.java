package employee;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepertmentService {
    private final EmployeeService employeeService;

    public DepertmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaximalSalary(int deoartment) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartament() == deoartment)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinimalSalary(int deoartment) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartament() == deoartment)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getEmployee(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartament() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> getEmployeeGroipedByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
