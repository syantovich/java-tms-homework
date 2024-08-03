package org.example.observable;


import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String eventType, String message) {
        for (EventListener listener : listeners) {
            listener.update(eventType, message);
        }
    }

    public void triggerEvent(String eventType, String message) {
        System.out.println("Event triggered: " + eventType + " - " + message);
        notifyListeners(eventType, message);
    }
}