package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

public final class Surgeon extends Doctor {
    public Surgeon(String name, int code, boolean isDefaultDoctor) {
        super(name, code, isDefaultDoctor);
        Doctor.saveDoctor(this, code);
    }

    public Surgeon(String name, int code) {
        this(name, code, false);
    }

    @Override
    public void toHeal() {
        System.out.println("I'm going to cut your skin");
    }

}
