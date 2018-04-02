package com.midokura.geo;

public class Region {

    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    public Region(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double x1() {
        return x1;
    }

    public double y1() {
        return y1;
    }

    public double x2() {
        return x2;
    }

    public double y2() {
        return y2;
    }

    public boolean contains(Coordinate coordinate) {
        // TODO
        return true;
    }
}
