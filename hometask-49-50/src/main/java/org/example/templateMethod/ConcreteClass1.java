package org.example.templateMethod;

import org.example.templateMethod.abstr.AbstractClass;

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass1: primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass1: primitiveOperation2");
    }

    @Override
    protected void doSmth() {
        System.out.println("ConcreteClass1: hook");
    }
}
