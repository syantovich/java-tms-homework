package org.example.observable;

public class ConcreteListener implements EventListener {
    private String name;

    public ConcreteListener(String name) {
        this.name = name;
    }

    @Override
    public void update(String eventType, String message) {
        System.out.println(name + " received event: " + eventType + " with message: " + message);
    }
}