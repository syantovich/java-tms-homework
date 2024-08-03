package org.example.abstractFactory.impl;

import org.example.abstractFactory.Chair;
import org.example.abstractFactory.FurnitureFactory;
import org.example.abstractFactory.Sofa;
import org.example.abstractFactory.chairs.VictorianChair;

public class VictorianFurnitureFactory  implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
