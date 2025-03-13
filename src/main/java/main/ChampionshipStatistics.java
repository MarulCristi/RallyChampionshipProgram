package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        return (double) totalPoints / drivers.size(); // Return the average points per driver in double
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers.isEmpty()) {
            return "No drivers registered.";
        }

        Map<String, Integer> countryPoints = new HashMap<>(); // Map of country and their points

        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int currentPoints = driver.getPoints();
            if (countryPoints.containsKey(country)) { // If the country is already in the map
                int totalPoints = countryPoints.get(country) + currentPoints;
                countryPoints.put(country, totalPoints); // Put the country and their total points in the map
            } else {
                countryPoints.put(country, currentPoints);
            }

        }

        int maxPoints = 0;
        String mostSuccessfulCountry = "";

        for (String country : countryPoints.keySet()) { // Iterate through the countries
            int points = countryPoints.get(country);
            if(points > maxPoints) {
                maxPoints = points;
                mostSuccessfulCountry = country;
            }

        }
        return mostSuccessfulCountry;

    }

    public static int getTotalRacesHeld() {
        
        return ChampionshipManager.getTotalRaces(); // Return the amount of races held. As said, this is allowed by TA.
    }
}
