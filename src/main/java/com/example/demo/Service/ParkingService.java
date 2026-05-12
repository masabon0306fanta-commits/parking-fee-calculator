package com.example.demo.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Parking;

@Service
public class ParkingService {
	
	
	public int calculateTotalFee(Parking parking , LocalDateTime entryTime) {
		
		LocalDateTime now = LocalDateTime.now();
		//差分計算
		long minutes =ChronoUnit.MINUTES.between(entryTime, now);
		//料金計算
		long hours =(long)Math.ceil((double)minutes/60);
		//最低値
		if(hours == 0) hours =1;
		
		return (int)(hours*parking.getFee());
		
		
	}
}