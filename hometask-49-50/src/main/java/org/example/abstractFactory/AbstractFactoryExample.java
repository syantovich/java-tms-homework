package org.example.abstractFactory;

import org.example.abstractFactory.impl.ModernFurnitureFactory;
import org.example.abstractFactory.impl.VictorianFurnitureFactory;

public class AbstractFactoryExample implements Runnable {
    public void run() {
        System.out.println("Abstract Factory Example");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();
        modernChair.sit();
        modernSofa.lieDown();

        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();
        victorianChair.sit();
        victorianSofa.lieDown();
        System.out.println("Abstract Factory Example end");
        System.out.println("--------------------------------------------------");
    }
}
