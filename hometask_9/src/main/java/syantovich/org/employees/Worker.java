package syantovich.org.employees;

import syantovich.org.abstr.Employee;
import syantovich.org.enums.EWorkerTypes;

public class Worker extends Employee {
    public Worker(String firsName, String lastName, double workExperience) {
        super(firsName, lastName, workExperience, EWorkerTypes.WORKER);
    }

    public Worker(String firsName, String lastName) {
        this(firsName, lastName, 0);
    }
}
