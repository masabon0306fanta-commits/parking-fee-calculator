package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.ParkingRepository;
import com.example.demo.Service.ParkingService;
import com.example.demo.entity.Parking;



@Controller
public class ParkingController {
	
	@Autowired 
	private ParkingRepository ParkingRepository;
	
	@GetMapping("/home")
	public String ShowFtirsPage(Model model){
		List<Parking> list=ParkingRepository.findAll().stream().toList();
		model.addAttribute("ParkingList",list);
		return "FirstPage";
	}
	
	@GetMapping("/fee")
	public String Fee(@RequestParam("parkingId") Integer id, Model model) {
		Parking select =ParkingRepository.findById(id).orElse(null);

		System.out.println("中身は{"+select.getFee()+"}");

		
		model.addAttribute("selectParking",select);
		
		
		return "FeePage";
	}
	
	@GetMapping("/calcution")
	public String calcution(@RequestParam("parkingId")Integer id,Model model){
		Parking parking =ParkingRepository.findById(id).orElse(null);
		if(parking != null) {
			parking.setEntryTime(LocalDateTime.now());
			ParkingRepository.save(parking);
		}
		
		ParkingService ParkingService= new ParkingService();
		
		int fee = ParkingService.calculateTotalFee(parking, parking.getEntryTime());
		model.addAttribute("totalPrice", fee);
		model.addAttribute("selectParking", parking);
		
		return "calcutionPage";
	}
	
}
