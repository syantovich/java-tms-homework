package org.syantovich.abstr;

import javax.print.Doc;
import java.util.HashMap;

public abstract class Doctor {
    String name;
    public Doctor(String name) {
        this.name = name;
    }
    public abstract void toHeal();

}
