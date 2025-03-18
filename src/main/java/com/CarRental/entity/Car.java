package main.java.com.CarRental.entity;

public class Car {
    private String company;
    private String model;
    private double rentalPricePerDay;
    private boolean isAvailable;

    public Car(String company, String model, double rentalPricePerDay) {
        this.company = company;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    public String getDescription() {
        return company + " " + model + " - $" + rentalPricePerDay + " per day";
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }
}
