package org.example.abstractFactory.sofas;

import org.example.abstractFactory.Sofa;

public class ModernSofa implements Sofa {
    @Override
    public void lieDown() {
        System.out.println("Sitting on a modern sofa");
    }
}
