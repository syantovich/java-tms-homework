package org.syantovich.doctors;

import org.syantovich.abstr.Doctor;

import java.util.HashMap;

public final class Therapist extends Doctor {

    private final HashMap<Integer, Doctor> doctorsByPlanCodes = new HashMap<Integer, Doctor>();
    private int defaultDoctorCode;

    public Therapist(String name) {
        super(name);
    }

    public void saveDoctor(Doctor doctor) {
        this.doctorsByPlanCodes.put(doctor.code,doctor);
    }

    public Doctor getDoctorByCode(int code) {
        return this.doctorsByPlanCodes.getOrDefault(code, this);
    }
    @Override
    public void toHeal() {
        System.out.println("I'll give you analgin");
    }
}
