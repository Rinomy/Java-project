import com.carrental.servecis.RentalService;
import com.carrental.entity.Car;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
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
            rentalService.rentCar(choice);
        }
        scanner.close();
    }
        }