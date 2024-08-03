package org.example.observable;

public class ObservableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Observer Example");
        EventSource eventSource = new EventSource();

        EventListener listener1 = new ConcreteListener("Listener1");
        EventListener listener2 = new ConcreteListener("Listener2");

        eventSource.addListener(listener1);
        eventSource.addListener(listener2);

        eventSource.triggerEvent("EventType1", "This is the first event");
        eventSource.triggerEvent("EventType2", "This is the second event");
        System.out.println("Observer Example end");
        System.out.println("--------------------------------------------------");
    }
}
