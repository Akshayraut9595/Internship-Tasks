package com.example.RideSharingApplication.service;

import com.example.RideSharingApplication.model.Driver;
import com.example.RideSharingApplication.model.DriverDTO;
import com.example.RideSharingApplication.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverServiceImplementation implements DriverService{
    private final DriverRepository driverRepository;

    public DriverServiceImplementation(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public List<DriverDTO> getAllDrivers(){
        return driverRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private DriverDTO convertToDTO(Driver driver) {
        return new DriverDTO(driver.getId(), driver.getName(), driver.getEmail(), driver.getPhoneNumber(), driver.getPassword(), driver.getVehicleName(), driver.getAvailable());
    }

    @Override
    public DriverDTO registerDriver(DriverDTO driverDTO){
        Driver driver = convertToEntity(driverDTO);
        Driver registerDriver = driverRepository.save(driver);
        return convertToDTO(registerDriver);
    }

    private Driver convertToEntity(DriverDTO driverDTO){
        Driver driver = new Driver();
        driver.setName(driverDTO.name());
        driver.setId(driverDTO.id());
        driver.setAvailable(driverDTO.isAvailable());
        driver.setEmail(driverDTO.email());
        driver.setPassword(driverDTO.password());
        driver.setPhoneNumber(driverDTO.phoneNumber());
        driver.setVehicleName(driverDTO.vehicleName());
        return driver;
    }

    @Override
    public Optional<DriverDTO> getDriverById(Long id){
        return driverRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public DriverDTO updateDriver(Long id, DriverDTO driverDTO){
        Driver driver = driverRepository.findById(id).orElseThrow();
        if(driverDTO.name() != null){
            driver.setName(driverDTO.name());
        }

        if(driverDTO.email() != null){
            driver.setEmail(driverDTO.email());
        }

        if(driverDTO.isAvailable() != null){
            driver.setAvailable(driverDTO.isAvailable());
        }

        if(driverDTO.password() != null){
            driver.setPassword(driverDTO.password());
        }

        if(driverDTO.phoneNumber() != null){
            driver.setPhoneNumber(driverDTO.phoneNumber());
        }

        if(driverDTO.vehicleName() != null){
            driver.setVehicleName(driverDTO.vehicleName());
        }

        Driver updatedDriver = driverRepository.save(driver);
        return convertToDTO(updatedDriver);
    }

    @Override
    public void deleteDriver(Long id){
        driverRepository.deleteById(id);
    }

    @Override
    public DriverDTO updateDriverAvailability(Long id, Map<String, Object> isAvailable){
        Driver driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));

        if (isAvailable.containsKey("isAvailable")) {
            driver.setAvailable((Boolean) isAvailable.get("isAvailable"));
        }

        driverRepository.save(driver);
        return convertToDTO(driver);
    }
}
