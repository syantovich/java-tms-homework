package org.syantovich.abstr;

import javax.print.Doc;
import java.util.HashMap;

public abstract class Doctor {
    String name;
    private static final HashMap<Integer, Doctor> doctorsByPlanCodes = new HashMap<Integer, Doctor>();
    private static int defaultDoctorCode;

    public Doctor(String name, int code, boolean isDefaultDoctor) {
        this.name = name;
        if (isDefaultDoctor) {
            Doctor.defaultDoctorCode = code;
        }
    }
    public Doctor(String name, int code){
        this(name,code,false);
    }

    public static void saveDoctor(Doctor doctor, int code) {
        Doctor.doctorsByPlanCodes.put(code, doctor);
    }

    public static Doctor getDoctorByCode(int code) {
        if (Doctor.doctorsByPlanCodes.containsKey(code)) {
            return Doctor.doctorsByPlanCodes.get(code);
        } else {
            return Doctor.doctorsByPlanCodes.get(Doctor.defaultDoctorCode);
        }
    }

    public abstract void toHeal();

}
