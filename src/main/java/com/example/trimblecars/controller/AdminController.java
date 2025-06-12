package com.example.trimblecars.controller;

import com.example.trimblecars.entity.Lease;
import com.example.trimblecars.entity.User;
import com.example.trimblecars.respository.UserRepository;
import com.example.trimblecars.service.LeaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.trimblecars.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final CarService carService;
    private final LeaseService leaseService;
    private final UserRepository userRepository;

    public AdminController(CarService carService, LeaseService leaseService, UserRepository userRepository) {
        this.carService = carService;
        this.leaseService = leaseService;
        this.userRepository = userRepository;
    }

    @GetMapping("/leases")
    public ResponseEntity<List<Lease>> getAllLeases() {
        return ResponseEntity.ok(leaseService.getAllLeases());
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}

