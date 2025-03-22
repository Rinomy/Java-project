package com.carrental.servecis;
import com.carrental.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Car> cars;

    public RentalService() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAvailableCars() {
        System.out.println("Available cars for rent:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car.getDescription());
            }
        }
    }

    public void rentCar(int index) {
        if (index >= 0 && index < cars.size() && cars.get(index).isAvailable()) {
            cars.get(index).rent();
            System.out.println("You have rented: " + cars.get(index).getDescription());
        } else {
            System.out.println("This car is not available for rent.");
        }
    }

    public void returnCar(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.get(index).returnCar();
            System.out.println("You have returned: " + cars.get(index).getDescription());
        }
    }

}
