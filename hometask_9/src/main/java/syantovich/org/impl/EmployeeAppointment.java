package syantovich.org.impl;

import syantovich.org.abstr.Employee;

public interface EmployeeAppointment {
    public void addEmployee(Employee newEmployee);
    public Employee findEmployee(String firstName);
    public void printAllEmployeesInfo();
}
