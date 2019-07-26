package com.opticalix.ml;

import java.io.Serializable;

public class AccData implements Serializable {
    private static final String SEP = ",";
    public float x;
    public float y;
    public float z;

    public AccData(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public AccData(String line) {
        String[] split = line.split(SEP);
        this.x = Float.parseFloat(split[0]);
        this.y = Float.parseFloat(split[1]);
        this.z = Float.parseFloat(split[2]);
    }

    public static Double combinedAcc(AccData accData) {
        return Math.sqrt(Math.pow(accData.x, 2) + Math.pow(accData.y, 2) + Math.pow(accData.z, 2));
    }
}
