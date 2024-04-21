package org.example.task1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread());
    }
}
