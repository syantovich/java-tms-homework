package org.example.templateMethod;

import org.example.templateMethod.abstr.AbstractClass;

public class TemplateMethodExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Template Method Example");
        AbstractClass class1 = new ConcreteClass1();
        class1.templateMethod();

        AbstractClass class2 = new ConcreteClass2();
        class2.templateMethod();
        System.out.println("Template Method Example end");
        System.out.println("--------------------------------------------------");
    }
}
