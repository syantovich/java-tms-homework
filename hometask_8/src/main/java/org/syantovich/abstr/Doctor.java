package org.syantovich.abstr;


public abstract class Doctor {
    public String name;
    public int code;
    public Doctor(String name, int code) {
        this.name = name;
        this.code = code;
    }
    public Doctor(String name){
        this(name,0);
    }

    public abstract void toHeal();

}
