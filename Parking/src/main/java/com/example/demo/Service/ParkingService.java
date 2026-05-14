package com.example.demo.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Parking;

@Service
public class ParkingService {
	
	
	public long calculateTotalFee(Parking parking ) {
		
		LocalDateTime now = LocalDateTime.now();
		//差分計算
		long minutes =ChronoUnit.MINUTES.between(parking.getEntryTime(), now);
		long hours =(long)Math.ceil((double)minutes/60);
		//最低値
		if(hours == 0) {
			hours =1;
			}
		long fee =hours*parking.getFee();
		//最大料金判定
		if(parking.getMaxfee()!=null) {
		if(fee>parking.getMaxfee()) {
			fee=parking.getMaxfee();
		}
		}
		return fee;
		
		
	}
}