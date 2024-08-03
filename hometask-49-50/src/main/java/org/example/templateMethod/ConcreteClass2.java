package org.example.templateMethod;

import org.example.templateMethod.abstr.AbstractClass;

public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass2: primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass2: primitiveOperation2");
    }
}
