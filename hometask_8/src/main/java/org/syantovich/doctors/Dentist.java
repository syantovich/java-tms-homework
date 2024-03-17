package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

public class Dentist extends Doctor {
    public Dentist(String name) {
        super(name);
    }

    @Override
    public void toHeal() {
        System.out.println("I've already removed some teeth. You must pay 1 000 000$ to me.");
    }
}
