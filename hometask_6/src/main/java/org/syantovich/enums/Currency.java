package org.syantovich.enums;

public enum Currency {
    BYN(1000),
    USD(306.58);

    public double multiplier;

    Currency(double multiplier) {
        this.multiplier = multiplier;
    }
    }
