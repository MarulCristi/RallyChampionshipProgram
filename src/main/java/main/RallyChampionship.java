package main;

public class RallyChampionship extends ChampionshipManager {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Initialize 5 drivers with their respective cars
        Driver driver1 = new Driver("Sébastien Ogier", "France", new AsphaltCar("Toyota", "GR Yaris", 380, 0.35));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new GravelCar("Hyundai", "i20 N", 375, 0.42));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Puma", 378, 0.40));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Škoda", "Fabia RS", 368, 0.37));
        Driver driver5 = new Driver("Elfyn Evans", "Wales", new AsphaltCar("Citroën", "C3", 372, 0.38));

        // Register drivers
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);
        manager.registerDriver(driver5);

        // Add points to drivers
        driver1.addPoints(40);
        driver2.addPoints(40);
        driver3.addPoints(30);
        driver4.addPoints(30);
        driver5.addPoints(15);

        // Print driver standings
        manager.getDriverStandings();

        System.out.println();

        // Print leading driver thanks to singleton instance
        System.out.println("===== CHAMPIONSHIP LEADER =====\n" + ChampionshipManager.getLeadingDriver().getName() + " with " + ChampionshipManager.getLeadingDriver().getPoints() + " points");

        System.out.println();

        // Print championship statistics
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Average points per person: " + ChampionshipStatistics.calculateAveragePointsPerDriver(ChampionshipManager.getDrivers()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(ChampionshipManager.getDrivers()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println();

        // Initialize races
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        RallyRaceResult race2 = new RallyRaceResult("Carlo Rally", "Monaco");

        // Record race results
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        race1.recordResult(driver5, 5, 0);

        System.out.println("===== RACE RESULTS =====");
        race1.getResults();
        System.out.println();

        // Drivers change cars
        System.out.println("===== " + driver2.getName() + " and " + driver4.getName() + " CHANGED CAR =====");
        driver2.setCar(new AsphaltCar("Ford", "e32dz", 380, 0.5));
        driver4.setCar(new GravelCar("Hyundai", "i20", 380, 0.3));

        // Change positions
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        race2.recordResult(driver5, 5, driver5.getPoints());

        // Print race 2 results
        race2.getResults();

        System.out.println();

        // Car performance results

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        float totalPerformanceAsphalt = 0;
        float totalPerformanceGravel = 0;
        int AsphaltCarCount = 0;
        int GravelCarCount = 0;
        for (Driver driver : ChampionshipManager.getDrivers()) {
            if (driver.getCar(null) instanceof AsphaltCar) { // Check if the car is an AsphaltCar
                totalPerformanceAsphalt+=driver.getCar(null).calculatePerformance(); // Calculate performance and add to total
                AsphaltCarCount++;
            } else {
                driver.getCar(null).calculatePerformance();
                totalPerformanceGravel+=driver.getCar(null).calculatePerformance();
                GravelCarCount++;
            }
        }
        System.out.println("Gravel Car Performance: " + Math.round(totalPerformanceGravel / GravelCarCount * 10d) / 10d); // Round to 1 decimal places;
        System.out.println("Asphalt Car Performance: " + Math.round(totalPerformanceAsphalt / AsphaltCarCount * 10d) / 10d); // Round to 1 decimal places;
        }
}
