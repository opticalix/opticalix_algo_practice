package com.opticalix.ml;

import java.io.Serializable;

public class AccData implements Serializable {
    public float x;
    public float y;
    public float z;

    public AccData(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
