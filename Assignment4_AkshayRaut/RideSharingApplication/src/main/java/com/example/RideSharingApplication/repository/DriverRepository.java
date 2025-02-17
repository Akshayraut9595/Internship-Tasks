package com.example.RideSharingApplication.repository;

import com.example.RideSharingApplication.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
