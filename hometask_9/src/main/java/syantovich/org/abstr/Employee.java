package syantovich.org.abstr;

import syantovich.org.enums.EWorkerTypes;

public class Employee {
    public final String firsName;
    public final String lastName;
    public double workExperience;
    public EWorkerTypes position;

    public Employee(String firsName, String lastName, double workExperience, EWorkerTypes position) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.workExperience = workExperience;
        this.position = position;
    }

    public Employee(String firsName, String lastName, double workExperience) {
        this(firsName, lastName, workExperience, EWorkerTypes.WORKER);
    }

    public Employee(String firsName, String lastName) {
        this(firsName, lastName, 0);
    }

    public String getFullInfo() {
        String fullInfo = this.firsName + " " + this.lastName + " " + this.workExperience + " years " + this.position.displayName;
        System.out.println("Full info: " + fullInfo);
        return fullInfo;
    }
}
