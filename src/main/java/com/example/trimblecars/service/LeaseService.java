package com.example.trimblecars.service;

import com.example.trimblecars.entity.Car;
import com.example.trimblecars.entity.Lease;
import com.example.trimblecars.respository.CarRepository;
import com.example.trimblecars.respository.LeaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaseService {

    private final LeaseRepository leaseRepository;
    private final CarRepository carRepository;

    public LeaseService(LeaseRepository leaseRepository, CarRepository carRepository) {
        this.leaseRepository = leaseRepository;
        this.carRepository = carRepository;
    }

    public Lease startLease(Lease lease) {
        long activeLeases = leaseRepository.findByCustomerId(lease.getCustomerId())
                .stream()
                .filter(l -> l.getEndDate() == null)
                .count();

        if (activeLeases >= 2) {
            throw new RuntimeException("Cannot lease more than 2 cars at a time.");
        }

        Car car = carRepository.findById(lease.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (!"AVAILABLE".equals(car.getStatus())) {
            throw new RuntimeException("Car is not available for lease");
        }

        lease.setStartDate(LocalDate.now());
        lease.setEndDate(null);

        car.setStatus("ON_LEASE");
        carRepository.save(car);

        return leaseRepository.save(lease);
    }

    public void endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() -> new RuntimeException("Lease not found"));
        lease.setEndDate(LocalDate.now());
        leaseRepository.save(lease);

        Car car = carRepository.findById(lease.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setStatus("AVAILABLE");
        carRepository.save(car);
    }

    public List<Lease> getLeasesByCustomer(Long customerId) {
        return leaseRepository.findByCustomerId(customerId);
    }

    public List<Lease> getLeasesByCar(Long carId) {
        return leaseRepository.findByCarId(carId);
    }

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }
}

