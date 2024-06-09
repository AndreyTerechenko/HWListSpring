package employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/emppoyee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public void add(@RequestParam String firstName, @RequestParam String lostName) {
        employeeService.add(firstName, lostName);
    }

    @GetMapping(path = "/remove")
    public void remove(@RequestParam String firstName, @RequestParam String lostName) {

        employeeService.remove(firstName, lostName);
    }


    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lostName) {
        return employeeService.find(firstName, lostName);
    }

    @GetMapping(path = "/all")
    public Employee all() {
        return all();
    }
}