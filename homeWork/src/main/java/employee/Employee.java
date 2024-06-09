package employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lostName;

    public Employee(String firstName, String lostName) {
        this.firstName = firstName;
        this.lostName = lostName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLostName() {
        return lostName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lostName, employee.lostName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lostName);
    }

    @Override
    public String toString() {
        return "Сотрудники{\n" +
                "Имя = '" + firstName + '\'' +
                ", Фамилия = '" + lostName + '\'' +
                '}';
    }
}
