package com.example.RideSharingApplication.service;

import com.example.RideSharingApplication.model.DriverDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DriverService {
    DriverDTO registerDriver(DriverDTO driverDTO);
    List<DriverDTO> getAllDrivers();
    Optional<DriverDTO> getDriverById(Long id);
    DriverDTO updateDriver(Long id, DriverDTO driverDTO);
    void deleteDriver(Long id);
    DriverDTO updateDriverAvailability(Long id, Map<String, Object> isAvailable);
}
