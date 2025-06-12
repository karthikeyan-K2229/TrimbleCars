package com.example.trimblecars.respository;


import com.example.trimblecars.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findByCustomerId(Long customerId);
    List<Lease> findByCarId(Long carId);
}
