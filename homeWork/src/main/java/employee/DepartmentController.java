package employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/departmens")
public class DepartmentController {
    private final DepertmentService depertmentService;

    public DepartmentController(DepertmentService depertmentService) {
        this.depertmentService = depertmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMax(int departmentId) {
        return depertmentService.getMaximalSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMin(int departmentId) {
        return depertmentService.getMinimalSalary(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAll(int departmentId) {
        return depertmentService.getEmployee(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll() {
        return depertmentService.getEmployeeGroipedByDepartment();
    }
}
