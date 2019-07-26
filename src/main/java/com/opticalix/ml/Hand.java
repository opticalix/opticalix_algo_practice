package com.opticalix.ml;

public enum Hand {
    LEFT(0),
    RIGHT(1);

    private final int val;

    public int getVal() {
        return val;
    }

    Hand(int val) {
        this.val = val;
    }
}
