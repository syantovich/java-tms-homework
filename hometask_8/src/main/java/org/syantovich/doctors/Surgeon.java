package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

public final class Surgeon extends Doctor {
    public Surgeon(String name, int code) {
        super(name, code);
    }

    @Override
    public void toHeal() {
        System.out.println("I'm going to cut your skin");
    }

}
