package main;

public class GravelCar extends RallyCar { // Depends on RallyCar
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower); // make, model, horsepower taken from RallyCar
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel() {
        return this.suspensionTravel;
    }

    public double calculatePerformance() {
        return getHorsePower() * 0.3 + (suspensionTravel * 100) * 0.7; // basic calculation for performance of a Gravel Car
    }
}
