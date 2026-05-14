package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Parking;

public interface ParkingRepository extends JpaRepository <Parking, Integer>{

}
