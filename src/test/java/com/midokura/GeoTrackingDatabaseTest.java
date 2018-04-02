package com.midokura;

import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.midokura.geo.Coordinate;
import com.midokura.geo.Region;

import static org.junit.Assert.assertTrue;

public class GeoTrackingDatabaseTest {

    @Test
    public void testSimple() throws Exception {
        // Given a geo tracking database.
        GeoTracking db = new GeoTrackingDatabase();

        // And a list of devices.
        List<Coordinate> coordinates =
            readFromResource("com/midokura/devices_simple.txt");

        // When adding the devices to the database.
        for (Coordinate coordinate : coordinates) {
            db.addDevice(coordinate);
        }

        // Then querying the database should return correct results.
        List<Coordinate> result1 = db.findDevices(new Region(-1, -1, 1, 1));

        assertEquals(result1, coordinates);
    }

    private List<Coordinate> readFromResource(String resource) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(resource).toURI());
        List<String> lines = Files.readAllLines(path);
        List<Coordinate> result = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] coordinates = line.split("\\s+");
            result.add(new Coordinate(Double.parseDouble(coordinates[0]),
                                      Double.parseDouble(coordinates[1])));
        }
        return result;
    }

    private static void assertEquals(List<Coordinate> actual,
                                     List<Coordinate> expected) {
        Assert.assertEquals(new HashSet<>(actual), new HashSet<>(expected));
    }
}
