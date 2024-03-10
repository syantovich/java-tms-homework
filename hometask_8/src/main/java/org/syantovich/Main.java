package org.syantovich;

import org.syantovich.abstr.Doctor;
import org.syantovich.doctors.Dentist;
import org.syantovich.doctors.Surgeon;
import org.syantovich.doctors.Therapist;

public class Main {
    public static void main(String[] args) {
        new Surgeon("Anderi", 1);
        new Dentist("Ivan", 2);
        new Therapist("Egor", 3, true);

        Patient[] patients = {new Patient(1), new Patient(2), new Patient(3), new Patient(2), new Patient(155)};
        for (Patient patient :
                patients) {
            patient.toHeal();
        }
    }
}
