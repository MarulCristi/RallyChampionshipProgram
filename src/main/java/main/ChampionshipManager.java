package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance; // Singleton instance
    private static List<Driver> drivers; // List of drivers
        private List<RallyRaceResult> races; // List of races
        private static int totalDrivers;
        private static int totalRaces;
    
        public ChampionshipManager() {
            drivers = new ArrayList<>(); // Initialize drivers as a new ArrayList
            races = new ArrayList<>();
    }
    
        public static ChampionshipManager getInstance() { // Singleton instance
            if (instance == null) {
                instance = new ChampionshipManager();
            }
            return instance;
        }
    
        public void registerDriver(Driver driver) {
            drivers.add(driver);
            totalDrivers++;
        }
    
        public void addRaceResult(RallyRaceResult result) {
            races.add(result);
            totalRaces++;
        }   
    
        public List<Driver> getDriverStandings() {
            int i = 1;
            if(totalDrivers == 0 && totalRaces == 0) { // If there are no drivers
                System.out.println("No drivers to see Championship results of.");
                return null;
            }
            for (Driver driver : drivers) {
                System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
                i++;
            }
            return drivers;
        }
    
        public static Driver getLeadingDriver() { // Get the leading driver
            if (totalDrivers == 0) {
                System.out.println("No drivers to see Championship results of.");
                return null;
            }
            Driver leadingDriver = drivers.get(0); // Initialize leading driver as the first driver
            for (Driver driver : drivers) {
                if (driver.getPoints() > leadingDriver.getPoints()) {
                    leadingDriver = driver; // If the driver has more points than the leading driver, set the driver as the leading driver
                }
            }
            return leadingDriver;
        }
    
        public static int getTotalChampionshipPoints() { // Get the total championship points
            int totalPoints = 0;
            for (Driver driver : drivers) {
                totalPoints += driver.getPoints();
            }
            return totalPoints;
        }
    
        public static int getTotalRaces() { // Added this method to get the total number of races, TA said it's allowed.
            return totalRaces;
        }
    
        public static int getTotalDrivers() { // Added this method to get the total number of drivers, TA said it's allowed.
            return totalDrivers;
        }
    
        public static List<Driver> getDrivers() { // Added this method to get the list of drivers, I don't know if it's allowed, but I don't see any other way to use it in the main method.
            return drivers;
    }
}
