package com.example.trimblecars.controller;

import com.example.trimblecars.entity.Lease;
import com.example.trimblecars.service.LeaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {

    private final LeaseService leaseService;

    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    @PostMapping("/start")
    public ResponseEntity<Lease> startLease(@RequestBody Lease lease) {
        return ResponseEntity.ok(leaseService.startLease(lease));
    }

    @PostMapping("/end/{leaseId}")
    public ResponseEntity<Void> endLease(@PathVariable Long leaseId) {
        leaseService.endLease(leaseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Lease>> getCustomerLeases(@PathVariable Long customerId) {
        return ResponseEntity.ok(leaseService.getLeasesByCustomer(customerId));
    }
}

