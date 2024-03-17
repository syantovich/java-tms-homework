package org.syantovich;

import org.syantovich.abstr.Doctor;
import org.syantovich.doctors.Dentist;
import org.syantovich.doctors.Surgeon;
import org.syantovich.doctors.Therapist;

public class Main {
    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Anderi");
        Dentist dentist = new Dentist("Ivan");
        Therapist mainTherapist = new Therapist("Egor");
        mainTherapist.saveDoctor(surgeon, 1);
        mainTherapist.saveDoctor(dentist, 2);

        Patient[] patients = {new Patient(1, mainTherapist), new Patient(2, mainTherapist), new Patient(3, mainTherapist), new Patient(2, mainTherapist), new Patient(155, mainTherapist)};
        for (Patient patient :
                patients) {
            patient.toHeal();
        }
    }
}
