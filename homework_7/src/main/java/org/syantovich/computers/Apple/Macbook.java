package org.syantovich.computers.Apple;

import org.syantovich.abstr.Apple;

public class Macbook extends Apple {
    @Override
    public void getClassName() {
        super.getClassName();
        System.out.println("I'm Macbook");
    }
}
