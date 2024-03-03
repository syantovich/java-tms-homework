package org.syantovich.animals;

import org.syantovich.impl.Voice;

public class Dog implements Voice {
    String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void doVoice() {
        System.out.println("Aw, aw, aw. My name is " + name);
    }
}
