package main;

public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) { // Constructor depending on RallyCar
        this.name = name;
        this.country = country;
        this.car = car;
        
    }

    public String getName() {
        return this.name;
    }

    
    public String getCountry() {
        return this.country;
    }

    public int getPoints() {
        return this.points;
    }

    public RallyCar getCar(RallyCar car) { // Get car from driver. This method is not used in the project.
        return this.car;
    }

    public void setCar(RallyCar car) { // Set a car for driver.
        this.car = car;
    }

    public void addPoints(int points) { // Add points to driver.
        this.points += points;   
    }


}
