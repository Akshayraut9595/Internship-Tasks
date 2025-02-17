package com.example.RideSharingApplication.service;


import com.example.RideSharingApplication.model.Passenger;
import com.example.RideSharingApplication.model.PassengerDTO;
import com.example.RideSharingApplication.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImplementation implements PassengerService{
    private final PassengerRepository passengerRepository;

    public PassengerServiceImplementation(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<PassengerDTO> getAllPassengers(){
        return passengerRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PassengerDTO convertToDTO(Passenger passenger) {
        return new PassengerDTO(passenger.getId(), passenger.getName(), passenger.getEmail(), passenger.getPhoneNumber(), passenger.getPassword());
    }

    @Override
    public PassengerDTO registerPassenger(PassengerDTO passengerDTO){
        Passenger passenger = convertToEntity(passengerDTO);
        Passenger registerPassenger = passengerRepository.save(passenger);
        return convertToDTO(registerPassenger);
    }

    private Passenger convertToEntity(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger();
        passenger.setName(passengerDTO.name());
        passenger.setId(passengerDTO.id());
        passenger.setEmail(passengerDTO.email());
        passenger.setPassword(passengerDTO.password());
        passenger.setPhoneNumber(passengerDTO.phoneNumber());

        return passenger;
    }

    @Override
    public Optional<PassengerDTO> getPassengerById(Long id){
        return passengerRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public PassengerDTO updatePassenger(Long id, PassengerDTO passengerDTO){
        Passenger driver = passengerRepository.findById(id).orElseThrow();
        if(passengerDTO.name() != null){
            driver.setName(passengerDTO.name());
        }

        if(passengerDTO.email() != null){
            driver.setEmail(passengerDTO.email());
        }

        if(passengerDTO.password() != null){
            driver.setPassword(passengerDTO.password());
        }

        if(passengerDTO.phoneNumber() != null){
            driver.setPhoneNumber(passengerDTO.phoneNumber());
        }

        Passenger updatedPassenger = passengerRepository.save(driver);
        return convertToDTO(updatedPassenger);
    }

    @Override
    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }
}
