package com.example.RideSharingApplication.service;



import com.example.RideSharingApplication.model.PassengerDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PassengerService {
    PassengerDTO registerPassenger(PassengerDTO passengerDTO);
    List<PassengerDTO> getAllPassengers();
    Optional<PassengerDTO> getPassengerById(Long id);
    PassengerDTO updatePassenger(Long id, PassengerDTO passengerDTO);
    void deletePassenger(Long id);
}
