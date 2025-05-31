package com.carrental.servecis;
import com.carrental.dto.request.CarRequest;
import com.carrental.dto.response.CarResponse;
import com.carrental.dto.response.RentalResponse;
import com.carrental.entity.RentalCar;
import com.carrental.enums.PaymentStatus;
import com.carrental.mapper.CarMapper;
import com.carrental.mapper.RentalMapper;
import com.carrental.repository.CarRepository;
import com.carrental.repository.RentalRepository;
import com.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;
    private final CarMapper carMapper;
    private final RentalMapper rentalMapper;

    public CarResponse createCar(CarRequest request) {
        var car = carMapper.toEntity(request);
        car.setIsAvailable(true);
        var savedCar = carRepository.save(car);
        return carMapper.toResponse(savedCar);
    }
    public CarResponse updateCar(Long id, CarRequest request) {
        return carRepository.findById(id)
                .map(u -> carMapper.updateEntity(u, request))
                .map(carRepository::save)
                .map(carMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public CarResponse getCarById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Page<CarResponse> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable).map(carMapper::toResponse);
    }

    public void deleteCar(Long id) {
        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete car with id: " + id, e);
        }
    }

    public Page<CarResponse> getAvailableCars(Pageable pageable) {
        return carRepository.findAllByIsAvailable(true, pageable).map(carMapper::toResponse);
    }

    @Transactional
    public RentalResponse rentCar(Long userId, Long carId){
        var car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!car.getIsAvailable()){
            throw new RuntimeException("Car not available");
        }

        car.setIsAvailable(false);
        var now = LocalDateTime.now();
        var rentalCar = RentalCar.builder()
                .carId(car.getId())
                .userId(user.getId())
                .paymentStatus(PaymentStatus.NOT_PAYED)
                .rentalStartDate(LocalDateTime.now())
                .rentalEndDate(now.plusDays(1L))
                .totalCost(car.getRentalPricePerDay())
                .build();
        carRepository.save(car);
        var savedRentalCar = rentalRepository.save(rentalCar);
        return rentalMapper.toResponse(savedRentalCar);
    }

//    public void rentCar(int index) {
//        if (index >= 0 && index < cars.size() && cars.get(index).isAvailable()) {
//            cars.get(index).rent();
//            System.out.println("You have rented: " + cars.get(index).getDescription());
//        } else {
//            System.out.println("This car is not available for rent.");
//        }
//    }
//
//    public void getCarById(Long id) {
//        if (index >= 0 && index < cars.size()) {
//            cars.get(index).returnCar();
//            System.out.println("You have returned: " + cars.get(index).getDescription());
//        }
//    }

}
