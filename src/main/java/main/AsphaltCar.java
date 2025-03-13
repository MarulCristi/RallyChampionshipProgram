package main;

public class AsphaltCar extends RallyCar{ // Depends on RallyCar
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower); // make, model, horsepower taken from RallyCar
        this.downforce = downforce;
    }

    public double getDownforce() {
        return this.downforce;
    }

    public double calculatePerformance() {
        return getHorsePower() * 0.7 + (downforce * 100) * 0.3; // basic calculation for performance of an Asphalt Car
    }
}
