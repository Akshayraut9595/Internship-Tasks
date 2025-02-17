package com.example.RideSharingApplication.repository;

import com.example.RideSharingApplication.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
