package com.example.RideSharingApplication.controller;


import com.example.RideSharingApplication.model.PassengerDTO;
import com.example.RideSharingApplication.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<PassengerDTO> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id){
        Optional<PassengerDTO> passenger = passengerService.getPassengerById(id);
        return passenger.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PassengerDTO registerPassenger(@RequestBody PassengerDTO passengerDTO){
        return passengerService.registerPassenger(passengerDTO);
    }

    @PutMapping("/{id}")
    public PassengerDTO updatePassenger(@PathVariable Long id, @RequestBody PassengerDTO passengerDTO){
        return passengerService.updatePassenger(id, passengerDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
    }
}
