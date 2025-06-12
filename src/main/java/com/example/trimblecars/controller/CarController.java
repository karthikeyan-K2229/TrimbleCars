package com.example.trimblecars.controller;

import com.example.trimblecars.entity.Car;
import com.example.trimblecars.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/register")
    public ResponseEntity<Car> registerCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.registerCar(car));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Car>> getOwnerCars(@PathVariable Long ownerId) {
        return ResponseEntity.ok(carService.getCarsByOwner(ownerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }
}
