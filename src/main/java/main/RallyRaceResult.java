package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult { // Depends on RaceResult, which is an interface
    private String raceName;
    private String location;
    private Map<Driver, Integer> results; // Map of Driver and their position in

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>(); // Initialize results as a new HashMap
    }

    public String getRaceName() {
        return this.raceName;
    }

    public String getLocation() {
        return this.location;
    }

    public void recordResult(Driver driver, int position, int points) {
        driver.addPoints(-driver.getPoints()); // Reset points to 0
        driver.addPoints(points); // Add points to driver
        results.put(driver, position); // Put driver and their position in the results map
    }

    public int getDriverPoints(Driver driver) {
        return driver.getPoints();
    }

    public List<Driver> getResults() {
        if (results.isEmpty()) {
            System.out.println("No driver in " + this.location + ".");
            return new ArrayList<>(); // Return an empty list if no driver in the location
        }

        List<Driver> sortedDrivers = new ArrayList<>(results.keySet());

        sortedDrivers.sort((d1, d2) -> results.get(d1).compareTo(results.get(d2))); // Sort drivers by their points.

        System.out.println("Race: " + this.raceName + " (" + this.location + ")");
        for (Driver driver : sortedDrivers) {

            System.out.println("\t" + "Position " + results.get(driver) + ": " + driver.getName() + " - " + driver.getPoints() + " points");
        }
        System.out.println();
        return sortedDrivers;
    }

}
