package com.midokura;

import java.util.LinkedList;
import java.util.List;

import com.midokura.geo.Coordinate;
import com.midokura.geo.Region;

public final class GeoTrackingDatabase implements GeoTracking {

    private final List<Coordinate> coordinates;

    public GeoTrackingDatabase() {
        coordinates = new LinkedList<>();
    }

    @Override
    public void addDevice(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    @Override
    public boolean removeDevice(Coordinate coordinate) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Coordinate> findDevices(Region region) {
        // TODO: Enhance performance
        List<Coordinate> result = new LinkedList<>();
        for (Coordinate coordinate : coordinates) {
            if (region.contains(coordinate)) {
                result.add(coordinate);
            }
        }
        return result;
    }

    @Override
    public int countDevices(Region region) {
        // TODO
        throw new UnsupportedOperationException();
    }
}
