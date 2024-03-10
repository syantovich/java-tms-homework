package syantovich.org;

import syantovich.org.abstr.Employee;
import syantovich.org.employees.Director;
import syantovich.org.employees.Worker;

public class Main {
    public static void main(String[] args) {
        Employee worker1 = new Worker("Ivan", "Ivanov", 4);
        Employee worker2 = new Worker("Petr", "Petrov", 3);
        Employee worker3 = new Worker("Anton", "Antonovich", 1);

        Director director1 = new Director("Alexey", "Alexeichik", 10);
        Director director2 = new Director("Inna", "Inna", 20);

        director1.addEmployee(worker1);
        director1.addEmployee(worker2);

        director2.addEmployee(worker3);

        System.out.println("Director 1 employees");
        director1.printAllEmployeesInfo();

        System.out.println("Is worker3 in director1 " + director1.isContainWorker(worker3.firsName));
        System.out.println("Director 2 employees");
        director2.printAllEmployeesInfo();

        director1.addEmployee(director2);
        System.out.println("Director 1 new employees");
        director1.printAllEmployeesInfo();

        System.out.println("Is worker3 in director1 " + director1.isContainWorker(worker3.firsName));

    }
}
