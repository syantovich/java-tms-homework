package org.syantovich.animals;

import org.syantovich.impl.Voice;

public class Cat implements Voice {
    String name;
    public Cat(String name){
        this.name = name;
    }

    @Override
    public void doVoice() {
        System.out.println("Myow, Myow, Myow. Don't you see, that this is " + name + "'s toy");
    }
}
