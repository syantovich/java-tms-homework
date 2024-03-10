package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

public final class Therapist extends Doctor {

    public Therapist(String name, int code, boolean isDefaultDoctor) {
        super(name,code,isDefaultDoctor);
        Doctor.saveDoctor(this, code);
    }

    public Therapist(String name, int code) {
        this(name, code, false);
    }

    @Override
    public void toHeal() {
        System.out.println("I'll give you analgin");
    }
}
