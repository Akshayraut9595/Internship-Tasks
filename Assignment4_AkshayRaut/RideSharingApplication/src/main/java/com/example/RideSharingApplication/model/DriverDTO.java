package com.example.RideSharingApplication.model;

public record DriverDTO(Long id, String name, String email, String phoneNumber, String password, String vehicleName, Boolean isAvailable) {}
