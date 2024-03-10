package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

public class Dentist extends Doctor {
    public Dentist(String name, int code, boolean isDefaultDoctor) {
        super(name, code, isDefaultDoctor);
        Doctor.saveDoctor(this, code);
    }

    public Dentist(String name, int code) {
        this(name, code, false);
    }

    @Override
    public void toHeal() {
        System.out.println("I've already removed some teeth. You must pay 1 000 000$ to me.");
    }
}
