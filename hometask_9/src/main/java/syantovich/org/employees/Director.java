package syantovich.org.employees;

import syantovich.org.abstr.Employee;
import syantovich.org.enums.EWorkerTypes;
import syantovich.org.impl.EmployeeAppointment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Director extends Employee implements EmployeeAppointment {

    Employee[] employees = new Employee[0];

    public Director(String firsName, String lastName, double workExperience) {
        super(firsName, lastName, workExperience, EWorkerTypes.DIRECTOR);
    }

    public Director(String firsName, String lastName) {
        this(firsName, lastName, 10);
    }

    @Override
    public void addEmployee(Employee newEmployee) {
        Employee[] newEmployees = Arrays.copyOf(this.employees, this.employees.length + 1);
        newEmployees[newEmployees.length - 1] = newEmployee;
        this.employees = newEmployees;
    }

    @Override
    public Employee findEmployee(String firstName) {
        for (Employee employee : this.employees) {
            if (Objects.equals(employee.firsName, firstName)) {
                return employee;
            }
            if (employee instanceof Director director) {
                Employee foundEmployee = director.findEmployee(firstName);
                if (foundEmployee != null) {
                    return foundEmployee;
                }
            }
        }
        return null;
    }

    public boolean isContainWorker(String firstName) {
        return this.findEmployee(firstName) != null;
    }

    @Override
    public void printAllEmployeesInfo() {
        for (Employee employee : this.employees) {
            employee.getFullInfo();

            if (employee instanceof Director director) {
                director.printAllEmployeesInfo();
            }
        }
    }
}
