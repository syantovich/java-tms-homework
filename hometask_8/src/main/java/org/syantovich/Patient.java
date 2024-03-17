package org.syantovich;

import org.syantovich.abstr.Doctor;
import org.syantovich.doctors.Therapist;

public class Patient {
    Doctor doctor;
    int code;

    public Patient(int code, Therapist therapist) {
        this.doctor = therapist.getDoctorByCode(code);
        this.code = code;
    }

    public void toHeal() {
        this.doctor.toHeal();
    }
}
