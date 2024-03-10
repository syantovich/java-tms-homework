package org.syantovich.enums;

public enum Profession {
    DIRECTOR(10),
    WORKER(3),
    HR(1.5);

    public double salaryRate;

    Profession(double salaryRate) {
        this.salaryRate = salaryRate;
    }
}
