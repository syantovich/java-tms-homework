package org.syantovich;

import org.syantovich.abstr.Doctor;

public class Patient {
    Doctor doctor;

    public Patient( int code) {
        this.doctor = Doctor.getDoctorByCode(code);
    }

    public void toHeal(){
        this.doctor.toHeal();
    }
}
