package com.carrental;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        /*RentalService rentalService = new RentalService(); // Fixed typo here
        rentalService.addCar(new Car("Toyota", "Corolla", 30));
        rentalService.addCar(new Car("Ford", "Mustang", 50));
        rentalService.addCar(new Car("BMW", "X5", 70));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            rentalService.displayAvailableCars();
            System.out.println("Enter the car number to rent (or -1 to exit):");
            int choice = scanner.nextInt();
            if (choice == -1) {
                break;
            }
            hello
            rentalService.rentCar(choice);
        }
        scanner.close();*/
    }
}
