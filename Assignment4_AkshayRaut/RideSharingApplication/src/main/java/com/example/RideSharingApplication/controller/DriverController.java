package com.example.RideSharingApplication.controller;

import com.example.RideSharingApplication.model.DriverDTO;
import com.example.RideSharingApplication.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping
    public List<DriverDTO> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id){
        Optional<DriverDTO>driverDTO =driverService.getDriverById(id);
        return driverDTO.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DriverDTO registerDriver(@RequestBody DriverDTO driverDTO){
        return driverService.registerDriver(driverDTO);
    }

    @PutMapping("/{id}")
    public DriverDTO updateDriver(@PathVariable Long id, @RequestBody DriverDTO driverDTO){
        return driverService.updateDriver(id, driverDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
    }

    @PatchMapping("/{id}")
    public DriverDTO updateDriverAvailability(@PathVariable Long id, @RequestBody Map<String, Object> isAvailable){
        return driverService.updateDriverAvailability(id, isAvailable);
    }
}
