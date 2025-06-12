package com.example.trimblecars.service;

import com.example.trimblecars.entity.Car;
import com.example.trimblecars.respository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car registerCar(Car car) {
        car.setStatus("AVAILABLE");
        return carRepository.save(car);
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByStatus("AVAILABLE");
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<Car> getCarsByOwner(Long ownerId) {
        return carRepository.findByOwnerId(ownerId);
    }
}

