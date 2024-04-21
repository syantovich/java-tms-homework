package org.example.task4;

public class LogThreeTimeThread extends Thread {
    private final String logString;
    private final Marker marker;

    public LogThreeTimeThread(String logString, Marker marker) {
        this.logString = logString;
        this.marker = marker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (marker){
                System.out.println(logString);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
