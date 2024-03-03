package org.syantovich.computers;

import org.syantovich.abstr.Computer;

public class HP extends Computer {
    @Override
    public void getClassName() {
        System.out.println("I'm HP");
    }
}
