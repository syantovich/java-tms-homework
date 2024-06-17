package org.example;

import org.example.interfaces.Power;

public class RidePair implements Power {
    private final Horse horse;
    private final Rider rider;

    public RidePair(final Horse horse, final Rider rider) {
        this.horse = horse;
        this.rider = rider;
    }

    @Override
    public double getPower() {
        return (double) Math.round((rider.getPower() + horse.getPower()) * 1000) / 100;
    }

    @Override
    public String toString() {
        return rider.toString() + " - " + horse.toString() + " - Power: " + getPower();
    }
}
