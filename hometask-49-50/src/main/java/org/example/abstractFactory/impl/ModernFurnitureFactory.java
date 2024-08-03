package org.example.abstractFactory.impl;

import org.example.abstractFactory.Chair;
import org.example.abstractFactory.FurnitureFactory;
import org.example.abstractFactory.Sofa;
import org.example.abstractFactory.chairs.ModernChair;
import org.example.abstractFactory.sofas.ModernSofa;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
