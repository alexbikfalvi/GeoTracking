package com.midokura;

import java.util.List;

import com.midokura.geo.Coordinate;
import com.midokura.geo.Region;

/**
 * A geo-tracking interface.
 */
public interface GeoTracking {

    /**
     * Adds a new device given by the specified coordinates.
     * @param coordinate The device coordinates.
     */
    void addDevice(Coordinate coordinate);

    /**
     * Removes a device given by the specified coordinates.
     * @param coordinate The device coordinates.
     * @return True if the device exists, false otherwise.
     */
    boolean removeDevice(Coordinate coordinate);

    /**
     * Finds the coordinates of all devices located in the specified region.
     * @param region The region.
     * @return The list of device coordinates.
     */
    List<Coordinate> findDevices(Region region);

    /**
     * Counts all devices in the specified region.
     * @param region The region.
     * @return The number of devices.
     */
    int countDevices(Region region);
}
