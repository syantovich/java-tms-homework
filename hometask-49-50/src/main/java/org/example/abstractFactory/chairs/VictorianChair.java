package org.example.abstractFactory.chairs;

import org.example.abstractFactory.Chair;

public class VictorianChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sitting on a victorian chair");
    }
}
